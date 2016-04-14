package org.log

/**
  * Created by gennadi on 14.04.16.
  */

import org.slf4j.{ Logger => SLF4JLogger, LoggerFactory}
//import org.slf4j._

trait Logger {
  def error(message: => String): Unit = {
    if (slf4jLogger.isErrorEnabled) slf4jLogger.error(message)
  }

  def error(message: => String, t: Throwable): Unit = {
    if (slf4jLogger.isErrorEnabled) slf4jLogger.error(message, t)
  }

  def warn(message: => String): Unit = {
    if (slf4jLogger.isErrorEnabled) slf4jLogger.warn(message)
  }

  def warn(message: => String, t: Throwable): Unit = {
    if (slf4jLogger.isErrorEnabled) slf4jLogger.warn(message, t)
  }

  def info(message: => String): Unit = {
    if (slf4jLogger.isInfoEnabled) slf4jLogger.info(message)
  }

  def info(message: => String, t: Throwable): Unit = {
    if (slf4jLogger.isInfoEnabled) slf4jLogger.error(message, t)
  }

  def debug(message: => String): Unit = {
    if (slf4jLogger.isInfoEnabled) slf4jLogger.debug(message)
  }

  def debug(message: => String, t: Throwable): Unit = {
    if (slf4jLogger.isInfoEnabled) slf4jLogger.debug(message, t)
  }

  def trace(message: => String): Unit = {
    if (slf4jLogger.isInfoEnabled) slf4jLogger.trace(message)
  }

  def trace(message: => String, t: Throwable): Unit = {
    if (slf4jLogger.isInfoEnabled) slf4jLogger.trace(message, t)
  }

  protected val slf4jLogger: SLF4JLogger
}

trait Logging {
  self =>
  protected lazy val logger = new Logger {
    override protected val slf4jLogger = LoggerFactory getLogger self.getClass.getName
  }
}
