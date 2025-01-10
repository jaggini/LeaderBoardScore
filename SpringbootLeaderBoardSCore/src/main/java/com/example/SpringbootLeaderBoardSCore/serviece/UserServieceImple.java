package com.example.SpringbootLeaderBoardSCore.serviece;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Optional;
import java.util.Set;
import java.util.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.SpringbootLeaderBoardSCore.entity.Badge;
import com.example.SpringbootLeaderBoardSCore.entity.User;

import com.example.SpringbootLeaderBoardSCore.repository.UserRepository;

@Service
public class UserServieceImple implements UserServiece {

    @Autowired
    UserRepository userRepository;

    @Override
    public List<User> getAllUsersByScore() {
        List<User> u = userRepository.findAll();
        mergeSort(u, 0, u.size() - 1);
        return u;

    }

    @Override
    public User createUser(User u) {
        u.setUserId(u.getUserId());
        u.setUsername(u.getUsername());
        u.setBadges(new HashSet<>());
        return userRepository.save(u);
    }

    @Override
    public void deleteUser(String userId) {
        if (!userRepository.existsById(userId)) {
            throw new RuntimeException("user not found");
        }
        userRepository.deleteById(userId);

    }

    @Override
    public User updateUser(int score, String userId) {
        if (score < 0) {
            throw new IllegalArgumentException("Score can not ne negative");
        }
        User u = userRepository.findById(userId).orElseThrow(() -> new NoSuchElementException("User not found"));
        u.setScore(score);

        u.setBadges(setBadges(score));

        return userRepository.save(u);

    }

    public Set<Badge> setBadges(int score) {

        Set<Badge> badge = new HashSet<>();
        if (score >= 1 && score <= 30) {
            badge.add(Badge.CODE_NINJA);

        }
        if (score >= 30 && score <= 60) {
            badge.add(Badge.CODE_CHAMP);
        }
        if (score >= 60 && score <= 100) {
            badge.add(Badge.CODE_MASTER);

        }
        return badge;
    }

    @Override
    public Optional<User> getUserById(String userId) {
        return userRepository.findById(userId);
    }

    public void mergeSort(List<User> u, int low, int high) {

        if (low < high) {
            int mid = (low + high) / 2;
            mergeSort(u, low, mid);
            mergeSort(u, mid + 1, high);
            merge(u, low, mid, high);
        }

    }

    private void merge(List<User> u, int low, int mid, int high) {
        int left = mid - low + 1;
        int right = high - mid;
        List<User> leftArray = new ArrayList<>();
        List<User> rightArray = new ArrayList<>();

        for (int i = 0; i < left; i++) {
            leftArray.add(u.get(low + i));
        }
        for (int j = 0; j < right; j++) {
            rightArray.add(u.get(mid + 1 + j));
        }
        int i = 0, j = 0, k = low;
        while (i < left && j < right) {
            if (compareUser(leftArray.get(i), rightArray.get(j))) {
                u.set(k, rightArray.get(i));
                i++;

            } else {
                u.set(k, rightArray.get(j));
                j++;
            }
            k++;
        }
        while (i < left) {
            u.set(k, leftArray.get(i));
            i++;
            k++;

        }
        while (j < right) {
            u.set(k, rightArray.get(j));
            j++;
            k++;

        }
    }

    private boolean compareUser(User u1, User u2) {
        return u1.getScore() >= u2.getScore();
    }
}
