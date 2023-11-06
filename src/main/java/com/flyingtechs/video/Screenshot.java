package com.flyingtechs.video;

import javax.persistence.*;

@Entity
public class Screenshot {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "id", nullable = false)
    private Long id;

    @ManyToOne
    @JoinColumn(name = "live_video_class_id")
    private LiveVideoClass liveVideoClass;

    public LiveVideoClass getLiveVideoClass() {
        return liveVideoClass;
    }

    public void setLiveVideoClass(LiveVideoClass liveVideoClass) {
        this.liveVideoClass = liveVideoClass;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }
}
