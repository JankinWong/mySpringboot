package com.lagou;

import com.lagou.bean.User;
import com.lagou.repository.UserRepository;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import java.util.ArrayList;
import java.util.List;

@RunWith(SpringJUnit4ClassRunner.class)
@SpringBootTest(classes=Neo4jBootAppMain.class)
public class UserNodeTest {


    @Autowired
    UserRepository userRepository;

    /**
     * 创建用户节点 【批量创建】
     *
     * @throws Exception
     */
    @Test
    public void createUser() throws Exception {

        List<User> userNodes = new ArrayList<>();
        User userNode1 = new User();
        userNode1.setUid(1001L);
        userNode1.setName("李雷");
        userNode1.setAge(16);
        userNode1.setSex("男");
        List<String> hobbies1 = new ArrayList<>();
        hobbies1.add("游戏");
        hobbies1.add("学习");
        hobbies1.add("睡觉");
        hobbies1.add("学英语");
        userNode1.setHobbies(hobbies1);

        User userNode2 = new User();
        userNode2.setUid(1002L);
        userNode2.setName("韩梅梅");
        userNode2.setAge(15);
        userNode2.setSex("女");
        List<String> hobbies2 = new ArrayList<>();
        hobbies2.add("逛街");
        hobbies2.add("美食");
        hobbies2.add("学英语");
        hobbies2.add("玩王者");
        userNode2.setHobbies(hobbies2);


        userNodes.add(userNode1);
        userNodes.add(userNode2);
        userRepository.save(userNode1);
        userRepository.save(userNode2);

//        Iterable<User> iterable = userRepository.save(userNodes);
//        for (User user : iterable) {
//            System.out.println("创建节点：【" + user.getName() + "】成功！");
//        }

    }

    /**
     * 创建节点  == 内置关系
     */
    @Test
    public void createNodeandRelation(){

        User startNode = new User();
        startNode.setUid(1011L);
        startNode.setName("刘泽");
        startNode.setAge(22);
        startNode.setSex("男");
        List<String> hobbies = new ArrayList<>();
        hobbies.add("撸啊撸");
        hobbies.add("美食");
        hobbies.add("看jk");
        hobbies.add("玩王者");
        startNode.setHobbies(hobbies);

        User endNode1 = new User();
        endNode1.setUid(1012L);
        endNode1.setName("张婷");
        endNode1.setAge(17);
        endNode1.setSex("女");
        List<String> hobbies1 = new ArrayList<>();

        hobbies1.add("逛街");
        hobbies1.add("美食");
        hobbies1.add("学英语");
        hobbies1.add("穿jk");
        endNode1.setHobbies(hobbies1);

        User endNode2 = new User();
        endNode2.setUid(1013L);
        endNode2.setName("林志玲");
        endNode2.setAge(45);
        endNode2.setSex("女");

        List<String> hobbies2 = new ArrayList<>();
        hobbies2.add("穿丝袜");
        hobbies2.add("大长腿");
        hobbies2.add("大奶子");
        endNode2.setHobbies(hobbies2);

        startNode.addLikes(endNode1, "心地善良，人美", 2015,521 );
        startNode.addLikes(endNode2, "女神姐姐", 2011, 520);

        User userNode = userRepository.save(startNode);
        System.out.println("节点"+userNode.getName()+"创建成功！");

    }




}