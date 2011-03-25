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

import com.google.appengine.api.users.UserService;
import com.google.gson.Gson;

import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.multiaction.MultiActionController;
import org.springframework.web.servlet.view.RedirectView;

import java.util.Collection;
import java.util.HashMap;
import java.util.Map;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class PaypalController extends MultiActionController {

  private KiwiShopService kiwishopService;
  private Gson gson;
  private UserService userService;

  /**
   * Spring injected dependency using the setter.
   *
   * @param userService AppEngine UserService
   */
  public void setUserService(UserService userService) {
    this.userService = userService;
  }

  /**
   * Spring injected dependency using the setter.
   *
   */
  public void setKiwiShopService(KiwiShopService kiwishopService) {
    this.kiwishopService = kiwishopService;
  }

  /**
   * Spring injected dependency using the setter.
   * The gson transformer spits JSON output from java objects.
   *
   * @param gson a JSON-Java converter
   */
  public void setGson(Gson gson) {
    this.gson = gson;
  }

  /**
   * Checks the bean state against it's dependencies. init() is set as the
   * default-init-method for all spring configured beans.
   */
  public void init() {
    if (userService == null || gson == null || kiwishopService == null) {
      throw new IllegalStateException("initialize failed" +
          PaypalController.class.toString());
    }
  }

}
