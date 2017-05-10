package com.jonas.test.beanutils

import java.util.concurrent.Executors
import java.util.stream.IntStream

def executor = Executors.newSingleThreadExecutor()

IntStream.range(0, 4).forEach({ number -> executor.submit({ println "i m task $number" }) })

executor.shutdown()