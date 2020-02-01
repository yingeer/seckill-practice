package com.suny.service.impl;

import com.suny.dto.Exposer;
import com.suny.dto.SeckillExecution;
import com.suny.entity.Seckill;
import com.suny.exception.RepeatKillException;
import com.suny.exception.SeckillCloseException;
import com.suny.service.SeckillService;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import java.util.List;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(value ={"classpath:spring/spring-dao.xml", "classpath:spring/spring-service.xml"})
public class SeckillServiceImplTest {

    private Logger logger = (Logger) LoggerFactory.getLogger(this.getClass());

    @Autowired
    private SeckillService seckillService;

    @Before
    public void setUp() throws Exception {
    }

    @After
    public void tearDown() throws Exception {
    }

    @Test
    public void getSeckillList() {
        List<Seckill> seckillList = seckillService.getSeckillList();
        logger.info("list={}", seckillList);
        System.out.println(seckillList.toString());
        /**
         * 2019-08-20 17:23:11.216 [main] INFO  org.seckill.service.impl.SeckillServiceImplTest - list=[Seckill{seckillId=1000, name='1000元秒杀iPhoneX', number=100, startTime=Wed May 22 00:00:00 CST 2019, endTime=Thu May 23 00:00:00 CST 2019, createTime=Sun Aug 18 13:38:11 CST 2019}, Seckill{seckillId=1001, name='500元秒杀iPad2', number=200, startTime=Wed May 22 00:00:00 CST 2019, endTime=Thu May 23 00:00:00 CST 2019, createTime=Sun Aug 18 13:38:11 CST 2019}, Seckill{seckillId=1002, name='300元秒杀小米7', number=300, startTime=Wed May 22 00:00:00 CST 2019, endTime=Thu May 23 00:00:00 CST 2019, createTime=Sun Aug 18 13:38:11 CST 2019}, Seckill{seckillId=1003, name='200元秒杀红米note', number=400, startTime=Wed May 22 00:00:00 CST 2019, endTime=Thu May 23 00:00:00 CST 2019, createTime=Sun Aug 18 13:38:11 CST 2019}]
         * [Seckill{seckillId=1000, name='1000元秒杀iPhoneX', number=100, startTime=Wed May 22 00:00:00 CST 2019, endTime=Thu May 23 00:00:00 CST 2019, createTime=Sun Aug 18 13:38:11 CST 2019}, Seckill{seckillId=1001, name='500元秒杀iPad2', number=200, startTime=Wed May 22 00:00:00 CST 2019, endTime=Thu May 23 00:00:00 CST 2019, createTime=Sun Aug 18 13:38:11 CST 2019}, Seckill{seckillId=1002, name='300元秒杀小米7', number=300, startTime=Wed May 22 00:00:00 CST 2019, endTime=Thu May 23 00:00:00 CST 2019, createTime=Sun Aug 18 13:38:11 CST 2019}, Seckill{seckillId=1003, name='200元秒杀红米note', number=400, startTime=Wed May 22 00:00:00 CST 2019, endTime=Thu May 23 00:00:00 CST 2019, createTime=Sun Aug 18 13:38:11 CST 2019}]
         */
    }

    @Test
    public void getById() {
        long seckillId = 1000;
        Seckill seckill = seckillService.getById(seckillId);
        logger.info("seckill={}", seckill);
    }

    @Test
    public void exportSeckillUrl() {
        long seckillId = 1000;
        Exposer exposer = seckillService.exportSeckillUrl(seckillId);
        logger.info("exposer={}", exposer);
    }

    @Test
    public void executeSeckill() {
        long seckillId = 1000;
        Exposer exposer = seckillService.exportSeckillUrl(seckillId);
        if (exposer.isExposed()) {
            long userPhone = 12222222222L;
            String md5 = "3781463499435ea6016e4163568492c2";//使用上面的md5
            try {
                SeckillExecution seckillExecution = seckillService.executeSeckill(seckillId, userPhone, md5);
                logger.info("result={}", seckillExecution);
            } catch (SeckillCloseException | RepeatKillException e) {
                e.printStackTrace();
            }
        } else {
            logger.warn("秒杀未开启");
        }
    }

    @Test
    public void executeSeckillProducedureTest() {
        long seckillId = 1001;
        long phone = 1368011101;
        Exposer exposer = seckillService.exportSeckillUrl(seckillId);
        if (exposer.isExposed()) {
            String md5 = exposer.getMd5();
            SeckillExecution execution = seckillService.executeSeckillProcedure(seckillId, phone, md5);
            System.out.println(execution.getStateInfo());
        }
    }

}