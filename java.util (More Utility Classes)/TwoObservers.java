import java.util.concurrent.Flow;
import java.util.List;
import java.util.ArrayList;

// This is the first observing class.
class Watcher1 implements Flow.Subscriber<Integer> {
    private Flow.Subscription subscription;

    @Override
    public void onSubscribe(Flow.Subscription subscription) {
        this.subscription = subscription;
        subscription.request(Long.MAX_VALUE); // Request an unlimited number of items
    }

    @Override
    public void onNext(Integer item) {
        System.out.println("update() called, count is " + item);
    }

    @Override
    public void onError(Throwable throwable) {
        System.out.println("Error occurred: " + throwable.getMessage());
    }

    @Override
    public void onComplete() {
        System.out.println("Watcher1 done");
    }
}

// This is the second observing class.
class Watcher2 implements Flow.Subscriber<Integer> {
    private Flow.Subscription subscription;

    @Override
    public void onSubscribe(Flow.Subscription subscription) {
        this.subscription = subscription;
        subscription.request(Long.MAX_VALUE); // Request an unlimited number of items
    }

    @Override
    public void onNext(Integer item) {
        if (item == 0) {
            System.out.println("Done\u0007"); // Ring bell when done
        }
    }

    @Override
    public void onError(Throwable throwable) {
        System.out.println("Error occurred: " + throwable.getMessage());
    }

    @Override
    public void onComplete() {
        System.out.println("Watcher2 done");
    }
}

// This is the class being observed.
class BeingWatched implements Flow.Publisher<Integer> {
    private final List<Flow.Subscriber<? super Integer>> subscribers = new ArrayList<>();

    @Override
    public void subscribe(Flow.Subscriber<? super Integer> subscriber) {
        subscribers.add(subscriber);
        BeingWatchedSubscription subscription = new BeingWatchedSubscription(subscriber, 10);
        subscriber.onSubscribe(subscription);
    }

    private class BeingWatchedSubscription implements Flow.Subscription {
        private final Flow.Subscriber<? super Integer> subscriber;
        private final int period;
        private boolean cancelled;

        BeingWatchedSubscription(Flow.Subscriber<? super Integer> subscriber, int period) {
            this.subscriber = subscriber;
            this.period = period;
        }

        public void counter() {
            for (int i = period; i >= 0; i--) {
                if (cancelled) {
                    break;
                }
                for (Flow.Subscriber<? super Integer> sub : subscribers) {
                    sub.onNext(i);
                }
                try {
                    Thread.sleep(100);
                } catch (InterruptedException e) {
                    System.out.println("Sleep interrupted");
                }
            }
            for (Flow.Subscriber<? super Integer> sub : subscribers) {
                sub.onComplete();
            }
        }

        @Override
        public void request(long n) {
            if (n <= 0) {
                subscriber.onError(new IllegalArgumentException("Non-positive request"));
            } else {
                counter();
            }
        }

        @Override
        public void cancel() {
            cancelled = true;
        }
    }
}

class TwoObservers {
    public static void main(String[] args) {
        BeingWatched observed = new BeingWatched();
        Watcher1 observing1 = new Watcher1();
        Watcher2 observing2 = new Watcher2();

        observed.subscribe(observing1);
        observed.subscribe(observing2);
    }
}