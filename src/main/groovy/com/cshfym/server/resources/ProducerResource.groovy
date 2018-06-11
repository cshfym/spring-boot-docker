package com.cshfym.server.resources

import com.cshfym.server.models.BasicResponse
import com.cshfym.server.models.SimpleMessage
import com.cshfym.server.services.KafkaService
import groovy.util.logging.Slf4j
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.stereotype.Controller
import org.springframework.web.bind.annotation.CrossOrigin
import org.springframework.web.bind.annotation.RequestBody
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RequestMethod
import org.springframework.web.bind.annotation.ResponseBody

@Slf4j
@Controller
@CrossOrigin
@RequestMapping("/producer")
class ProducerResource {

    @Autowired
    KafkaService kafkaService

    @ResponseBody
    @RequestMapping(value="/send", method=RequestMethod.POST)
    BasicResponse sendMessage(@RequestBody SimpleMessage simpleMessage) {

        simpleMessage.timestamp = new Date()
        kafkaService.send(simpleMessage)

        new BasicResponse(success: true)
    }

}
