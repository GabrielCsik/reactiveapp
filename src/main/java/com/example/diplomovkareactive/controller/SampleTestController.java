package com.example.diplomovkareactive.controller;


import com.example.diplomovkareactive.entity.SampleTest;
import com.example.diplomovkareactive.entity.TestParams;
import com.example.diplomovkareactive.logic.BlockChain;
import com.example.diplomovkareactive.logic.Miner;
import com.example.diplomovkareactive.logic.User;
import com.example.diplomovkareactive.logic.UserInterface;
import com.example.diplomovkareactive.repo.SampleTestRepository;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.thymeleaf.spring5.context.webflux.IReactiveDataDriverContextVariable;
import org.thymeleaf.spring5.context.webflux.ReactiveDataDriverContextVariable;
import reactor.core.publisher.Mono;

import java.security.Security;
import java.text.DecimalFormat;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.Random;

@Controller
@Slf4j
public class SampleTestController {

    char[] chars = "abcdefghijklmnopqrstuvwxyz123456789".toCharArray();
    StringBuilder sb = new StringBuilder();
    Random random = new Random();
    char c;
    BlockChain blockChain = new BlockChain();

    @Autowired
    private SampleTestRepository sampleTestRepository;

    @GetMapping(value = "/fetch")
    public String getAllTests(final Model model){

        IReactiveDataDriverContextVariable reactiveDataDriverContextVariable
                =new ReactiveDataDriverContextVariable(
                        sampleTestRepository.findAll(),1);
        model.addAttribute("sampleTests",reactiveDataDriverContextVariable);
        return "allSampleTests";
    }

    @GetMapping(value = "/")
    public String getData(final Model model){

        return "allSampleTests";
    }


    @GetMapping(path = {"/edit/{id}"})
    public String createUpdateTest(Model model, @PathVariable("id") String id){
            Mono<SampleTest> movie = sampleTestRepository.findById(id);
//            log.info(" $$$$$ CREATE/UPDATED by ID Movie :: {}",movie);
            model.addAttribute("sampleTest",movie);

        return "addSampleTests";
    }

    @GetMapping(path = {"/edit"})
    public String editTest(Model model){
        model.addAttribute("testParams",new TestParams());
        return "addSampleTests";
    }

    @PostMapping(value = "/create")
    public String createTest(TestParams testParams){
        SampleTest test = play(testParams);
        sampleTestRepository.save(test).subscribe();
        return "redirect:/";
    }

    private SampleTest play(TestParams testParams) {
        Security.addProvider(new org.bouncycastle.jce.provider.BouncyCastleProvider());
        System.out.println("Enter number of users: ");
        ArrayList<User> users = (ArrayList<User>) createUsers((int)testParams.getNumberOfUsers());
        System.out.println("Enter number of miners: ");
        ArrayList<Miner> miners = (ArrayList<Miner>) createMiners((int)testParams.getNumberOfMiners());
        System.out.println("Enter difficulty: ");
        blockChain.setDifficulty((int)testParams.getHashDifficulty());
        System.out.println("Enter time of running in seconds: ");
        users.stream().forEach(p -> p.setUserList(users));
        for (User user : users) {
            user.start();
        }
        System.out.println("Started users");
        for (Miner miner : miners) {
            miner.start();
        }
        int allMiningPower = 0;
        float minerCount = 0;
        for (Miner miner : miners) {
            allMiningPower += miner.getMinerHashPower();
            minerCount++;
        }
        DecimalFormat df = new DecimalFormat("#.###");
        System.out.println("****************************************************");


        SampleTest sampleTest = new SampleTest();

        sampleTest.setAvgMiningPower(allMiningPower / minerCount);
        sampleTest.setNumOfBlocks(blockChain.getNumofBlocks());
        sampleTest.setNumOfTransactions(blockChain.getNumofTransactions());
        sampleTest.setNumOfBlocksPerSec(blockChain.getNumofBlocks() / testParams.getDuration());
        sampleTest.setNumOfTransactionsPerSec((double)blockChain.getNumofTransactions() / testParams.getDuration());
        sampleTest.setNumOfTransactionsPerBlock(blockChain.getNumofTransactions() / blockChain.getNumofBlocks());
        sampleTest.setNumberOfUsers(testParams.getNumberOfUsers());
        sampleTest.setNumberOfMiners(testParams.getNumberOfMiners());
        sampleTest.setHashDifficulty(testParams.getHashDifficulty());
        sampleTest.setDuration(testParams.getDuration());
        return sampleTest;
    }

    public List<User> createUsers(int numberOfUsers){

        ArrayList<User> users = new ArrayList<>();
        for(int i = 1; i<= numberOfUsers; i++){
            sb.setLength(0);
            for (int x = 1; x <= 5; x++) {
                c = chars[random.nextInt(chars.length)];
                sb.append(c);
            }
            if(users.contains(sb.toString())){ continue;}
            users.add(new User(sb.toString(),blockChain));
        }
        return users;
    }
    public List<Miner> createMiners(int numberOfUsers){
        ArrayList<Miner> miners = new ArrayList<>();
        for(int i = 1; i<= numberOfUsers; i++){
            sb.setLength(0);
            for (int x = 1; x <= 5; x++) {
                c = chars[random.nextInt(chars.length)];
                sb.append(c);
            }
            if(miners.contains(sb.toString())){ continue;}
            miners.add(new Miner(sb.toString(),blockChain));
        }
        return miners;
    }

    @GetMapping(path="/delete/{id}")
    public String deleteTest(Model model, @PathVariable("id") String id){
//        log.info(" ::::: DELETE MOVIE ID ::::: {}",id);
        sampleTestRepository.deleteById(id).subscribe();
        return "redirect:/";
    }




}
