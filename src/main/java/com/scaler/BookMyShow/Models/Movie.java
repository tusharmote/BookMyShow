package com.scaler.BookMyShow.Models;

import com.scaler.BookMyShow.Models.constants.BaseModel;
import com.scaler.BookMyShow.Models.constants.MovieFeatures;
import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.util.List;

@Entity
@Getter
@Setter
public class Movie extends BaseModel {
    private String name;
    private String description;
    private String language;
    @OneToMany
    private List<Show1> shows;
    @ManyToMany
    private List<Actor> actors;
    @ElementCollection
    @Enumerated(EnumType.STRING)
    private List<MovieFeatures> movieFeatures;
}
