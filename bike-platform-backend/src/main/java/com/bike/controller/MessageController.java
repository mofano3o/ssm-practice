package com.bike.controller;

    import com.bike.dto.MessageDto;
    import com.bike.serviceImpl.*;
    import com.bike.service.*;
    import com.bike.common.*;
    import com.bike.request.*;
    import com.bike.entity.*;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/message")
public class MessageController {

    @Autowired
    private IMessageService messageService;

    @PostMapping("/add")
    public Response<Message> add(@RequestBody Message request) {
        Message message = messageService.add(request);
        return Response.ok(message);
    }

    @PutMapping("/update")
    public Response<Message> update(@RequestBody Message old) {
        Message message = messageService.update(old);
        return Response.ok(message);
    }

    @GetMapping("/{id}")
    public Response<Message> detail(@PathVariable int id) {
        return Response.ok(messageService.detail(id));
    }

    @DeleteMapping("/{id}")
    public Response<String> delete(@PathVariable int id) {
        messageService.delete(id);
        return Response.ok();
    }

    @PostMapping("/list")
    public Response<ListResponse<MessageDto>> list(@RequestBody ListMessageRequest request) {
        return Response.ok(messageService.list(request));
    }

}
