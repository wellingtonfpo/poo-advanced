void main() {
    SimpleArray sharedSimplesArray = new SimpleArray(6);

    ArrayWriter writer1 = new ArrayWriter(1, sharedSimplesArray);
    ArrayWriter writer2 = new ArrayWriter(11, sharedSimplesArray);

    try (ExecutorService executorService = Executors.newCachedThreadPool()) {
        executorService.execute(writer1);
        executorService.execute(writer2);

        executorService.shutdown();

        boolean tasksEnded = executorService.awaitTermination(1, TimeUnit.MINUTES);

        if (tasksEnded) {
            System.out.printf("%nContents of SimpleArray:%n%s%n", sharedSimplesArray);
        } else {
            System.out.println("Timed out while waiting for tasks to finish.");
        }
    } catch (InterruptedException e) {
        System.out.println("Main thread interrupted while waiting for tasks to finish.");
    }
}
