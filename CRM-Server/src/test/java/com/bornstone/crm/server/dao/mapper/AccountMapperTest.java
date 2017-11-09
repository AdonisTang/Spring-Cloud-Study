/**
 *    Copyright 2015-2017 the original author or authors.
 *
 *    Licensed under the Apache License, Version 2.0 (the "License");
 *    you may not use this file except in compliance with the License.
 *    You may obtain a copy of the License at
 *
 *       http://www.apache.org/licenses/LICENSE-2.0
 *
 *    Unless required by applicable law or agreed to in writing, software
 *    distributed under the License is distributed on an "AS IS" BASIS,
 *    WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 *    See the License for the specific language governing permissions and
 *    limitations under the License.
 */
package com.bornstone.crm.server.dao.mapper;

import com.bornstone.crm.server.dao.domain.Account;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mybatis.spring.boot.test.autoconfigure.MybatisTest;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.junit4.SpringRunner;

import static org.springframework.test.util.AssertionErrors.assertEquals;

@RunWith(SpringRunner.class)
@MybatisTest()
public class AccountMapperTest {

    @Autowired
    private AccountMapper accountMapper;

    @Test
    public void findByStateTest() {
        Account account = new Account();
        account.setAccountType(1);
        account.setUsername("admin");
        account.setPassword("admin");
        Account accountDB = accountMapper.selectByUsernameAndPwd(account);
        assertEquals("用户名错误", "admin", accountDB.getUsername());
        assertEquals("密码错误", "admin", accountDB.getPassword());
        assertEquals("用户类型错误", 1, accountDB.getAccountType());
    }

    @Test
    public void findByIdTest() {
        Account account = accountMapper.selectByPK("1");
        assertEquals("用户名错误", "admin", account.getUsername());
        assertEquals("密码错误", "admin", account.getPassword());
        assertEquals("用户类型错误", 1, account.getAccountType());
    }
}
