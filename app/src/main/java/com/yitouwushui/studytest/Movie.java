package com.yitouwushui.studytest;

import java.util.List;

/**
 * Created by ding on 2017/2/17.
 */

public class Movie {

    public Rating rating;
    List<String> genres;
    String title;

    public Rating getRating() {
        return rating;
    }

    public void setRating(Rating rating) {
        this.rating = rating;
    }

    public List<String> getGenres() {
        return genres;
    }

    public void setGenres(List<String> genres) {
        this.genres = genres;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    @Override
    public String toString() {
        return "Movie{" +
                "rating=" + rating +
                ", genres=" + genres +
                ", title='" + title + '\'' +
                '}';
    }

    private class Rating {
        int max;
        double average;
        double stars;
        int min;

        @Override
        public String toString() {
            return "Rating{" +
                    "max=" + max +
                    ", average=" + average +
                    ", stars=" + stars +
                    ", min=" + min +
                    '}';
        }

        public int getMax() {
            return max;
        }

        public void setMax(int max) {
            this.max = max;
        }

        public double getAverage() {
            return average;
        }

        public void setAverage(double average) {
            this.average = average;
        }

        public double getStars() {
            return stars;
        }

        public void setStars(double stars) {
            this.stars = stars;
        }

        public int getMin() {
            return min;
        }

        public void setMin(int min) {
            this.min = min;
        }
    }
}
