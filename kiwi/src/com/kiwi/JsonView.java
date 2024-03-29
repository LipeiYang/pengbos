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

import org.springframework.web.servlet.view.AbstractView;

import javax.servlet.ServletOutputStream;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.Map;

/**
 * A simple View class that renders JSON formatted response for
 * AJAX clients.
 *
 */
public class JsonView extends AbstractView {

  @Override
  protected void renderMergedOutputModel(
      Map model, HttpServletRequest request, HttpServletResponse response)
      throws Exception {
    response.setContentType("text/plain");
    response.setHeader("Cache-Control", "no-cache");
    String json = model.get("responseJson").toString();
    ServletOutputStream out = response.getOutputStream();
    out.print(json);
    out.close();
  }

}
