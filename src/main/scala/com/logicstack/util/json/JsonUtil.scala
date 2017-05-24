package com.logicstack.util.json

import java.text.SimpleDateFormat

import com.fasterxml.jackson.databind.ser.impl.SimpleBeanPropertyFilter
import com.fasterxml.jackson.databind.{DeserializationFeature, ObjectMapper, PropertyNamingStrategy}
import com.fasterxml.jackson.datatype.jsr310.JavaTimeModule
import com.fasterxml.jackson.module.scala.DefaultScalaModule
import com.fasterxml.jackson.module.scala.experimental.ScalaObjectMapper

object JsonUtil {
  private val dateFormat = "yyyy-MM-dd'T'HH:mm:ssZZ"
  private val filter = SimpleBeanPropertyFilter.serializeAllExcept()
  private val javaTimeModule = new JavaTimeModule()

  val CamelCaseMapper = new ObjectMapper() with ScalaObjectMapper
  CamelCaseMapper.registerModules(DefaultScalaModule, javaTimeModule)
    .setPropertyNamingStrategy(PropertyNamingStrategy.LOWER_CAMEL_CASE)
    .configure(DeserializationFeature.FAIL_ON_UNKNOWN_PROPERTIES, false)
    .configure(DeserializationFeature.FAIL_ON_IGNORED_PROPERTIES, false)
    .configure(DeserializationFeature.ACCEPT_EMPTY_STRING_AS_NULL_OBJECT, true)
    .setDateFormat(new SimpleDateFormat(dateFormat))

  val SnakeCaseMapper = new ObjectMapper() with ScalaObjectMapper
  SnakeCaseMapper.registerModules(DefaultScalaModule, javaTimeModule)
    .setPropertyNamingStrategy(PropertyNamingStrategy.SNAKE_CASE)
    .configure(DeserializationFeature.FAIL_ON_UNKNOWN_PROPERTIES, false)
    .configure(DeserializationFeature.FAIL_ON_IGNORED_PROPERTIES, false)
    .configure(DeserializationFeature.ACCEPT_EMPTY_STRING_AS_NULL_OBJECT, true)
    .setDateFormat(new SimpleDateFormat(dateFormat))

}