package com.example.matchservice.service;

import com.example.matchservice.model.Like;
import com.example.matchservice.model.Match;
import com.example.matchservice.repository.MatchRepository;
import lombok.val;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.Optional;
import java.util.stream.Stream;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;

@ExtendWith(MockitoExtension.class)
class BaseMatchServiceTest {

    private static final Long developerId = 1L;
    private static final Long projectId = 2L;

    @Mock
    private MatchRepository matchRepository;
    @InjectMocks
    private BaseMatchService matchService;


    @Test
    void shouldReturnTrueWhenIsMatch() {
        //given
        when(matchRepository.existsByDeveloperIdAndProjectIdAndMatchIs(developerId, projectId))
                .thenReturn(true);
        //when
        val result = matchService.isMatch(developerId, projectId);
        //then
        assertTrue(result);
    }

    @Test
    void shouldReturnFalseWhenIsNotMatch() {
        //given
        when(matchRepository.existsByDeveloperIdAndProjectIdAndMatchIs(developerId, projectId))
                .thenReturn(false);
        //when
        val result = matchService.isMatch(developerId, projectId);
        //then
        assertFalse(result);
    }

    @Test
    void shouldAddLikeAndReturnTrueWhenIsMatch() {
        //given
        val match = Match.builder()
                .id(1L)
                .developerId(developerId)
                .projectId(projectId)
                .isMatch(false)
                .isLike(true)
                .build();
        val like = new Like(developerId, projectId);

        when(matchRepository.findByDeveloperIdAndProjectId(developerId, projectId))
                .thenReturn(Optional.of(match));
        //when
        val result = matchService.like(like);
        //then
        assertTrue(result);
    }

    @Test
    void shouldAddLikeAndReturnFalseWhenIsNotMatch() {
        //given
        val like = new Like(developerId, projectId);

        when(matchRepository.findByDeveloperIdAndProjectId(developerId, projectId))
                .thenReturn(Optional.empty());
        //when
        val result = matchService.like(like);
        //then
        assertFalse(result);
    }

    @ParameterizedTest
    @MethodSource("getUnLikeCases")
    void shouldUnlikeAndReturnFalse(Optional<Match> match, Like like) {
        //given
        when(matchRepository.findByDeveloperIdAndProjectId(developerId, projectId))
                .thenReturn(match);
        //when
        val result = matchService.unLike(like);
        //then
        assertFalse(result);
    }

    private static Stream<Arguments> getUnLikeCases() {
        return Stream.of(
                Arguments.of(
                        Optional.of(Match.builder()
                                .id(1L)
                                .developerId(developerId)
                                .projectId(projectId)
                                .isMatch(false)
                                .isLike(true)
                                .build()),
                        new Like(developerId, projectId)),
                Arguments.of(
                        Optional.empty(),
                        new Like(developerId, projectId))
        );
    }


}