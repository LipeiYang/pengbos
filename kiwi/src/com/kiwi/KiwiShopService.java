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


import com.google.appengine.api.mail.MailService;

import java.util.logging.Logger;


/**
 *
 * @author pengbos.com@gmail.com (Pengbos.com)
 */
public class KiwiShopService {

  private KiwiDao kiwiDao;
  private MailService mailService;
  private MailService.Message mailMessage;
  private static final Logger log = Logger.getLogger(
      KiwiShopService.class.getName());

  /**
   * Spring Dependecy Injection.
   *
   * @param mailService AppEngine's MailService instance.
   */
  public void setMailService(MailService mailService) {
    this.mailService = mailService;
  }

  /**
   * Spring Dependency Injection
   *
   * @param mailMessage a message instance.
   */
  public void setMailMessage(MailService.Message mailMessage) {
    this.mailMessage = mailMessage;
  }

  /**
   * Kiwi Data Access Object is injected into service class by the
   * spring dependency injection container.
   *
   * @param kiwiDao the DAO object to be injected
   */
  public void setKiwiDao(KiwiDao kiwiDao) {
    this.kiwiDao = kiwiDao;
  }

  /**
   * Checks the bean state against it's dependencies.
   */
  public void init() {
    if (kiwiDao == null || mailMessage == null || mailService == null) {
      throw new IllegalStateException("intialize failed" +
          KiwiShopService.class.toString());
    }
  }

  /**
   * Adds an item to the listing. A user needs to be logged in to add a
   * new item listing.
   *
   * @param item a POJO with Item details
   * @return a unique id for the item listing
   */
  public String addItem(Item item) {
    return kiwiDao.create(item).toString();
  }

}
