package com.wzy.demo.controller;


import com.wzy.demo.document.portDocument;
import com.wzy.demo.entity.Congressman;
import com.wzy.demo.entity.Tweets;
import com.wzy.demo.service.ICongressmanService;
import com.wzy.demo.service.ITweetsService;
import com.wzy.demo.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping("/port")
public class controller {

    @Autowired
    private UserService userService;
    @Autowired
    private ICongressmanService congressmanService;
    @Autowired
    private ITweetsService tweetsService;


    /**
     * 创建索引
     *
     * @return
     * @throws Exception
     */
    @PostMapping("/createIndex")
    public ResponseEntity<Boolean> createPortIndex(@RequestParam(value = "index") String index) throws Exception {
        return ResponseEntity.status(HttpStatus.CREATED).body(userService.createPortIndex(index));
    }

    /**
     * 新增文档
     *
     * @param document
     * @return
     * @throws Exception
     */
    @PostMapping("/createDocument")
    public ResponseEntity<Boolean> createUserDocument(@RequestBody portDocument document) throws Exception {
        return ResponseEntity.status(HttpStatus.CREATED).body(userService.createPortDocument(document));
    }

    /**
     * 批量新增文档
     * @param
     * @return
     * @throws Exception
     */
    @PostMapping("/bulkCreateDocument")
    public ResponseEntity<Boolean> bulkCreateUserDocument() throws Exception {

        List<portDocument> documentList = new ArrayList<>();

        List<Congressman> congressmanList = congressmanService.getCongressmanList();

        for (Congressman congressman : congressmanList) {
            String tweetName = null;
             String scrName = congressman.getTwitter();
             if(!scrName.isEmpty()){
                 tweetName = scrName.substring(20);
                 System.out.println("tweetname:"+tweetName);
             }
            List<Tweets> tweetsByOrder = tweetsService.getTweetsByOrder(tweetName);
            System.out.println("查到对应的推特信息条数:"+tweetsByOrder.size());
             if(!tweetsByOrder.isEmpty()&&tweetsByOrder.size()>0){
                 for (Tweets tweets : tweetsByOrder) {
                     portDocument portDocument = new portDocument();
                     portDocument.setUserName(tweets.getUserName());
                     portDocument.setScreenName(tweets.getScreenName());
                     documentList.add(portDocument);
                 }
             }

        }
        return ResponseEntity.status(HttpStatus.CREATED).body(userService.bulkCreateDocument(documentList));
    }
}
