import java.util.concurrent.Flow;

// This is the observing class.
class Watcher implements Flow.Subscriber<Integer> {
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
        System.out.println("Done");
    }
}

// This is the class being observed.
class BeingWatched implements Flow.Publisher<Integer> {
    @Override
    public void subscribe(Flow.Subscriber<? super Integer> subscriber) {
        BeingWatchedSubscription subscription = new BeingWatchedSubscription(subscriber, 10);
        subscriber.onSubscribe(subscription);
    }

    private static class BeingWatchedSubscription implements Flow.Subscription {
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
                subscriber.onNext(i);
                try {
                    Thread.sleep(100);
                } catch (InterruptedException e) {
                    System.out.println("Sleep interrupted");
                }
            }
            subscriber.onComplete();
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

class ObserverDemo {
    public static void main(String[] args) {
        BeingWatched observed = new BeingWatched();
        Watcher observing = new Watcher();
        observed.subscribe(observing);
    }
}