package com.example.demo.serivce;

import com.example.demo.dto.TopicDTO;
import com.example.demo.mapper.TopicMapper;
import com.example.demo.mapper.UserMapper;
import com.example.demo.model.Topic;
import com.example.demo.model.User;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class TopicService {

    @Autowired
    private TopicMapper topicMapper;
    @Autowired
    private UserMapper userMapper;

    public List<TopicDTO> list() {
        List<Topic> topics=topicMapper.list();
        List<TopicDTO> topicDTOList = new ArrayList<>();
        for(Topic topic:topics){
            User user = userMapper.findById(topic.getCreator());
            TopicDTO topicDTO = new TopicDTO();
            BeanUtils.copyProperties(topic,topicDTO);
            topicDTO.setUser(user);
            topicDTOList.add(topicDTO);
        }
        return topicDTOList;
    }
}
