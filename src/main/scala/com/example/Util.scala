package com.example

import java.util.concurrent.{Executors, TimeUnit}

import scala.concurrent.duration.{DurationInt, FiniteDuration}
import scala.concurrent.{Future, Promise}
import scala.util.Try

object Util {
  val duration: FiniteDuration = 2.seconds
  def delay[T](f: => T): Future[T] = {
    val scheduledThreadPool = Executors.newScheduledThreadPool(10)
    val p                   = Promise[T]()
    scheduledThreadPool.schedule(
      () => {
        p.complete(Try(f))
      },
      duration.toMillis,
      TimeUnit.MILLISECONDS
    )
    p.future
  }
}
