package edu.lazyprogrammer.completablefuture;

import java.util.List;
import java.util.concurrent.CompletableFuture;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.ThreadLocalRandom;

public class CombineFutureDemo {

    private static List<String> osList
            = List.of("RHEL", "Ubuntu", "Fedora", "Kali",
                    "Debian", "Linux-Mint");

    public static void main(String[] args)
            throws InterruptedException, ExecutionException {
        //dependentFutures();
        //independentFutures();
        //wheAllFutureComplete();
        whenAnyFeatureComplete();
    }

    private static void dependentFutures()
            throws InterruptedException, ExecutionException {
        System.out.println("=========CompletableFuture.thenCompose Demo=========");
        //Combining 2 DEPENDENT Futures using thenCompose
        CompletableFuture<Integer> getRadius
                = CompletableFuture.supplyAsync(() -> 10);

        CompletableFuture<Double> findArea = getRadius.thenCompose(radius -> {
            return CompletableFuture.supplyAsync(() -> Math.PI * radius * radius);
        });

        System.out.println("Area of the Circle: " + findArea.get());
    }

    private static void independentFutures()
            throws InterruptedException, ExecutionException {
        System.out.println("=========CompletableFuture.thenCombine Demo=========");
        //Combining 2 DEPENDENT Futures using thenCompose
        CompletableFuture<Double> getWeight
                = CompletableFuture.supplyAsync(() -> {
                    Double randomWeight = ThreadLocalRandom.current()
                            .nextDouble(30, 100);
                    System.out.println("Returning Weight: " + randomWeight);
                    return randomWeight;
                });

        CompletableFuture<Double> getHeight
                = CompletableFuture.supplyAsync(() -> {
                    Double randomHeight = ThreadLocalRandom.current()
                            .nextDouble(100, 200) / 100;
                    System.out.println("Returning Height: " + randomHeight);
                    return randomHeight;
                });

        //BMI= weight in kg/height^2 in m
        CompletableFuture<Double> calculatedBMI
                = getHeight.thenCombine(getWeight, (height, weight) -> {
                    return weight / (height * height);
                });

        System.out.println("Calculated BMI: " + calculatedBMI.get());
    }

    private static void wheAllFutureComplete()
            throws InterruptedException, ExecutionException {
        List<String> listOfServers = List.of("server1", "server2",
                "server3", "server4", "server5");

        List<CompletableFuture<String>> osDetailsFuture = listOfServers.stream()
                .map(server -> getOSDetails(server))
                .toList();

        CompletableFuture<Void> allOSFutureComplete = CompletableFuture
                .allOf(osDetailsFuture.toArray(CompletableFuture[]::new));

        CompletableFuture<List<String>> finalOSFuture
                = allOSFutureComplete.thenApply(future -> {
                    return osDetailsFuture.stream()
                            .map(osFuture -> osFuture.join())
                            .toList();
                });

        System.out.println(finalOSFuture.get());
    }

    private static CompletableFuture<String> getOSDetails(String server) {
        return CompletableFuture.supplyAsync(() -> {
            System.out.println(Thread.currentThread().getName()
                    + ": Connecting to " + server);
            System.out.println(Thread.currentThread().getName()
                    + ": Executing Command in " + server);
            sleep(ThreadLocalRandom.current()
                    .nextLong(500, 1000));
            return server + " : " + osList.get(ThreadLocalRandom.current()
                    .nextInt(0, 4));
        });
    }

    private static void whenAnyFeatureComplete()
            throws ExecutionException, InterruptedException {
        List<String> CDNServers = List.of("nam", "emea",
                "apac", "mx");

        List<CompletableFuture<String>> submitAllForContent
                = CDNServers.stream()
                        .map(server -> getContent(server))
                        .toList();

        CompletableFuture<Object> quickestContentCDN
                = CompletableFuture.anyOf(submitAllForContent
                        .toArray(CompletableFuture[]::new));

        System.out.println(quickestContentCDN.get());
    }

    private static CompletableFuture<String> getContent(String cdn) {
        return CompletableFuture.supplyAsync(() -> {
            System.out.println("Content Request Received at " + cdn);
            sleep(ThreadLocalRandom.current()
                    .nextLong(500, 5000));
            return "Content Received from " + cdn;
        });
    }

    private static void sleep(Long delay) {
        try {
            Thread.sleep(delay);
        } catch (InterruptedException ex) {
            System.err.println(ex.getMessage());
        }
    }
}