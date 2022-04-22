package com.example.diplomovkareactive.entity;


import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@Data
@AllArgsConstructor
@NoArgsConstructor
@ToString
@Document(collection = "sampleTest")
public class SampleTest {

    @Id
    private String id;
    private double avgMiningPower;
    private double numOfBlocks;
    private double numOfTransactions;
    private double numOfBlocksPerSec;
    private double numOfTransactionsPerSec;
    private double numOfTransactionsPerBlock;
    private double numberOfUsers;

    public SampleTest(double avgMiningPower, double numOfBlocks, double numOfTransactions, double numOfBlocksPerSec, double numOfTransactionsPerSec, double numOfTransactionsPerBlock, double numberOfUsers, double numberOfMiners, double hashDifficulty, double duration) {

        this.avgMiningPower = avgMiningPower;
        this.numOfBlocks = numOfBlocks;
        this.numOfTransactions = numOfTransactions;
        this.numOfBlocksPerSec = numOfBlocksPerSec;
        this.numOfTransactionsPerSec = numOfTransactionsPerSec;
        this.numOfTransactionsPerBlock = numOfTransactionsPerBlock;
        this.numberOfUsers = numberOfUsers;
        this.numberOfMiners = numberOfMiners;
        this.hashDifficulty = hashDifficulty;
        this.duration = duration;
    }

    public SampleTest() {
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public double getNumberOfUsers() {
        return numberOfUsers;
    }

    public void setNumberOfUsers(double numberOfUsers) {
        this.numberOfUsers = numberOfUsers;
    }

    public double getNumberOfMiners() {
        return numberOfMiners;
    }

    public void setNumberOfMiners(double numberOfMiners) {
        this.numberOfMiners = numberOfMiners;
    }

    public double getHashDifficulty() {
        return hashDifficulty;
    }

    public void setHashDifficulty(double hashDifficulty) {
        this.hashDifficulty = hashDifficulty;
    }

    public double getDuration() {
        return duration;
    }

    public void setDuration(double duration) {
        this.duration = duration;
    }

    private double numberOfMiners;
    private double hashDifficulty;
    private double duration;



    public double getAvgMiningPower() {
        return avgMiningPower;
    }

    public void setAvgMiningPower(double avgMiningPower) {
        this.avgMiningPower = avgMiningPower;
    }

    public double getNumOfBlocks() {
        return numOfBlocks;
    }

    public void setNumOfBlocks(double numOfBlocks) {
        this.numOfBlocks = numOfBlocks;
    }

    public double getNumOfTransactions() {
        return numOfTransactions;
    }

    public void setNumOfTransactions(double numOfTransactions) {
        this.numOfTransactions = numOfTransactions;
    }

    public double getNumOfBlocksPerSec() {
        return numOfBlocksPerSec;
    }

    public void setNumOfBlocksPerSec(double numOfBlocksPerSec) {
        this.numOfBlocksPerSec = numOfBlocksPerSec;
    }

    public double getNumOfTransactionsPerSec() {
        return numOfTransactionsPerSec;
    }

    public void setNumOfTransactionsPerSec(double numOfTransactionsPerSec) {
        this.numOfTransactionsPerSec = numOfTransactionsPerSec;
    }

    public double getNumOfTransactionsPerBlock() {
        return numOfTransactionsPerBlock;
    }

    public void setNumOfTransactionsPerBlock(double numOfTransactionsPerBlock) {
        this.numOfTransactionsPerBlock = numOfTransactionsPerBlock;
    }


}
