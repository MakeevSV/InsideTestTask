package com.makeev.inside.service;

import com.makeev.inside.dao.MessageRepo;
import com.makeev.inside.dto.MessageDto;
import com.makeev.inside.model.Message;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import java.util.stream.Collectors;

@Service
public class MessageService {

    ModelMapper modelMapper = new ModelMapper();

    private final MessageRepo messageRepo;
    @Autowired
    public MessageService(MessageRepo messageRepo) {
        this.messageRepo = messageRepo;
    }

    public void newMessage(MessageDto request){
        messageRepo.save(modelMapper.map(request,Message.class));
    }

    public List<MessageDto> getLastNMessage(MessageDto messageDto){

        return messageRepo
                .findAll(PageRequest.of(0,
                        keyChecker(messageDto).get(),
                        Sort.Direction.DESC,
                        "id"))
                .stream()
                .map(e -> modelMapper.map(e,MessageDto.class))
                .collect(Collectors.toList());

    }

    public Optional<Integer> keyChecker(MessageDto request){

        String str = request.getMessage().toLowerCase();
        Pattern pattern = Pattern.compile("history \\d+$");
        Matcher match = pattern.matcher(str);

        if(match.find()){
            String[] array = str.split("\\D+");
            return Optional.of(Integer.parseInt(String.join("", array)));
        }
        return Optional.empty();
    }
}
