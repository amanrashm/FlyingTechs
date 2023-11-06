package com.flyingtechs.video;

import com.flyingtechs.studentManagement.model.Note;
import com.flyingtechs.userManagement.model.User;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.util.List;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "Live_Video_Class")
public class LiveVideoClass {

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    @Column(name = "Live_Video_Class_id", nullable = false)
    private Long id;

    @Column
    private String title;

    @Column
    private String description;

    @Column
    @ManyToOne
    @JoinColumn(name = "host_id")
    private User host;

    @Column
    @ManyToMany
    @JoinTable(
            name = "live_video_class_cohosts",
            joinColumns = @JoinColumn(name = "class_id"),
            inverseJoinColumns = @JoinColumn(name = "user_id")
    )
    private List<User> cohosts;

    @Column
    @ManyToMany
    @JoinTable(
            name = "live_video_class_participants",
            joinColumns = @JoinColumn(name = "class_id"),
            inverseJoinColumns = @JoinColumn(name = "user_id")
    )
    private List<User> participants;

    @Column
    @OneToMany(mappedBy = "liveVideoClass")
    @JoinTable(
            name = "live_video_class_languages",
            joinColumns = @JoinColumn(name = "class_id"),
            inverseJoinColumns = @JoinColumn(name = "language_id")
    )
    private List<Language> languages;

    @Column
    private boolean audioEnabled;
    @Column
    private boolean videoEnabled;
    @Column
    private boolean screenSharingEnabled;
    @Column
    private boolean screenRecordingEnabled;
    @Column
    private boolean lowBuffer;

    @OneToMany(mappedBy = "liveVideoClass", cascade = CascadeType.ALL)
    private List<Screenshot> screenshots;

    @OneToMany(mappedBy = "liveVideoClass", cascade = CascadeType.ALL)
    private List<Note> notes;

    public LiveVideoClass(String title, String description, User host, List<User> cohosts, List<User> participants, List<Language> languages, boolean audioEnabled, boolean videoEnabled, boolean screenSharingEnabled, boolean screenRecordingEnabled, boolean lowBuffer, List<Screenshot> screenshots, List<Note> notes) {
        this.title = title;
        this.description = description;
        this.host = host;
        this.cohosts = cohosts;
        this.participants = participants;
        this.languages = languages;
        this.audioEnabled = audioEnabled;
        this.videoEnabled = videoEnabled;
        this.screenSharingEnabled = screenSharingEnabled;
        this.screenRecordingEnabled = screenRecordingEnabled;
        this.lowBuffer = lowBuffer;
        this.screenshots = screenshots;
        this.notes = notes;
    }
}