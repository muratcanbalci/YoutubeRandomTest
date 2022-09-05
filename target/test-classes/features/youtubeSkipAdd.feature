Feature: Select a video according to random number on youtube

  @Duplicate
  Scenario: Go to google and search a random number.
    Given Go to google
    When Result is between 1 with 5
    Then Go to youtube and search Matematik

  Scenario: Go to google and search a random number.
    Given Go to google
    When Result is between 5 with 10
    Then Go to youtube and search Türkçe

  Scenario: Select a video without playlist with TYT word in title
    Given List to videos without playlist
    When Search to TYT word in title
    Then Select video

  Scenario: Skip forwards video
    Given Video is playing
    When Skip 1st minute of video and pause
    Then Control to minute of video
