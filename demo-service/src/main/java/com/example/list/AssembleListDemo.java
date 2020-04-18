package com.example.list;

import com.alibaba.fastjson.JSONObject;
import com.example.model.FirstVo;
import com.example.model.SecondVo;
import com.example.model.User;

import java.util.ArrayList;
import java.util.List;

/**
 * @author naruto
 * @data 2019/1/30.
 */
public class AssembleListDemo {
    public static void main(String[] args) {

        List<User> userList = new ArrayList<>();
        User user1 = new User();
        user1.setGradeId(1);
        user1.setClassId(1);
        user1.setName("zhang1");
        user1.setAge(12);
        User user2 = new User();
        user2.setGradeId(1);
        user2.setClassId(1);
        user2.setName("zhang2");
        user2.setAge(13);
        User user3 = new User();
        user3.setGradeId(1);
        user3.setClassId(2);
        user3.setName("zhang3");
        user3.setAge(22);
        User user4 = new User();
        user4.setGradeId(1);
        user4.setClassId(2);
        user4.setName("zhang4");
        user4.setAge(121);
        User user5 = new User();
        user5.setGradeId(2);
        user5.setClassId(1);
        user5.setName("lisi1");
        user5.setAge(12);
        User user6 = new User();
        user6.setGradeId(2);
        user6.setClassId(2);
        user6.setName("lisi2");
        user6.setAge(33);
        User user7 = new User();
        user7.setGradeId(3);
        user7.setClassId(1);
        user7.setName("wangwu1");
        user7.setAge(12);
        User user8 = new User();
        user8.setGradeId(4);
        user8.setClassId(1);
        user8.setName("zhaoliu1");
        user8.setAge(21);


        userList.add(user1);
        userList.add(user2);
        userList.add(user3);
        userList.add(user4);
        userList.add(user5);
        userList.add(user6);
        userList.add(user7);
        userList.add(user8);

        Integer gradeId = 0;
        Integer classId = 0;

        List<FirstVo> firstVoList = new ArrayList<>();
        List<SecondVo> secondVoList = new ArrayList<>();
        FirstVo firstVo = new FirstVo();
        SecondVo secondVo = new SecondVo();
        List<User> users = new ArrayList<>();
        for (User user : userList) {
            if (user.getGradeId().equals(gradeId)) {
                if (user.getClassId().equals(classId)) {
                    List<User> voUserList = secondVo.getUserList();
                    voUserList.add(user);
                }else{
                    secondVo = new SecondVo();
                    users = new ArrayList<>();
                    users.add(user);
                    secondVo.setUserList(users);
                    secondVoList.add(secondVo);
                }

//                firstVo.setGradeId(user.getGradeId());
//                firstVo.setSecondVoList(secondVoList);
            }else{
                firstVo = new FirstVo();
                secondVoList = new ArrayList<>();
                secondVo = new SecondVo();
                users = new ArrayList<>();
                users.add(user);
                secondVo.setUserList(users);
                secondVoList.add(secondVo);
                firstVo.setGradeId(user.getGradeId());
                firstVo.setSecondVoList(secondVoList);
                firstVoList.add(firstVo);
            }
            secondVo.setClassId(user.getClassId());
            classId = user.getClassId();
            gradeId = user.getGradeId();

//            secondVoList.add(secondVo);

        }

        System.out.println("==========="+JSONObject.toJSON(firstVoList)+"===========");






    }
}
