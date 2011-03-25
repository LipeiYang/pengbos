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

import org.springframework.orm.jdo.support.JdoDaoSupport;

import java.util.Collection;
import java.util.HashMap;
import java.util.Map;
import javax.jdo.PersistenceManager;
import javax.jdo.Query;

/**
 * A JDO implementation object for VehicleDao.
 *
 * @author zoso@google.com (Anirudh Dewani)
 */
public class KiwiJdoDao extends JdoDaoSupport implements KiwiDao {

  @Override
  public String create(Item item) {

    /*
     * Uses Spring's JdoTemplate helper since the entity's state doesn't need
     * to be changed more than once. JdoTemplate will obtain and release a
     * PersistenceManager.
     */
    getJdoTemplate().makePersistent(item);
    return item.getId();
  }

  @Override
  public void update(String key, String user) {
    /*
     * Uses PersistenceManager to retrieve the entity, modify the state
     * and persist again. This has to be done with the same instance of
     * PersistenceManager since the entity continues to be bound to the manager
     * unless explicitly detached.
     */
    PersistenceManager pm = getPersistenceManager();
    Item item = pm.getObjectById(Item.class, Long.parseLong(key));
    item.setOwner(user);

    try {
      pm.makePersistent(item);
    }
    finally {
      releasePersistenceManager(pm);
    }
  }
}
