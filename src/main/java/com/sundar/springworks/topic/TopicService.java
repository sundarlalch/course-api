package com.sundar.springworks.topic;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import org.springframework.stereotype.Service;

@Service
public class TopicService {
	
	private List<Topic> topics = new ArrayList<>( Arrays.asList(
			new Topic("Spring","Spring Framework","Spring Framework Description"),
			new Topic("Java","Core Java","Core Java Description"),
			new Topic("Javascript","Javascript Frameworks","avascript Frameworks Description")
			
			
			));
	public List<Topic> getAllTopics()
	{
		return topics;
	}
	public Topic getTopic(String id) {
			return topics.stream().filter(t -> t.getId().equalsIgnoreCase(id)).findFirst().get();
	}
	public void addTopic(Topic topic) {
		topics.add(topic);
		
	}
	public void updateTopic(String id, Topic topic) {
		Topic temp = getTopic(id);
		temp.setName(topic.getName());	
		temp.setDescription(topic.getDescription());
	}
	public void deleteTopic(String id) {
		topics.removeIf(t -> t.getId().equalsIgnoreCase(id));
		
	}

}
