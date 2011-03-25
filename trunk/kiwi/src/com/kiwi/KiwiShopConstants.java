/* Copyright (c) 2009 Google Inc.
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *     http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */

package com.kiwi;

/**
 * Constants
 *
 */
public class KiwiShopConstants {

  public static final String JSON_MODEL = "responseJson";
  public static final String JSON_VIEW = "KiwiShopJson";
  public static final String AUTH_CONTINUE_URL = "/home.html";
  public static final String AUTH_LOGIN = "loginUrl";
  public static final String AUTH_LOGOUT = "logoutUrl";
  public static final String AUTH_USER = "user";
  public static final String BEAN_USERSERVICE = "userService";
  public static final String BEAN_DSSERVICE = "datastoreService";
  public static final String AUDIT_ENTITY = "Audit";
  public static final int PAGE_SIZE = 20;
  public static final String PAGE_PARAM = "page";
  public static final String MSG_BEAN_INIT_FAILURE = "One of the dependencies" +
      " wasn't set for ";
  public static final String CAR_KEY_PATTERN = "Car:";
  public static final String MSG_INVALID_NUMBER = "Please enter valid " +
      "numeric data";
  public static final String MSG_MISSING_PARAM = "Please enter all required " +
      "values";
  public static final String MSG_INVALID_SEARCH = "Please enter search criteria ";

  public enum Operator {
    EQUALS,
    LESS_THAN_EQUALS,
    GREATER_THAN_EQUALS
  }

  ;

}