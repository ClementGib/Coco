package com.cdx.coco.client.facade.courses;

import java.time.Instant;

public record CoursePreviewDTO(Integer id, 
        String title, 
        String author, 
        String introduction, 
        String description,
        Instant creationDate, 
        Integer likeCount, 
        String imageId) {

    private CoursePreviewDTO(Builder builder) {
        this(builder.id, builder.title, 
                builder.author, builder.introduction, 
                builder.description, builder.creationDate,
                builder.likeCount, builder.imageId);
    }

    public static class Builder {
        private Integer id;
        private String title;
        private String author;
        private String introduction;
        private String description;
        private Instant creationDate;
        private Integer likeCount;
        private String imageId;

        public Builder(final Integer id) {
            this.id = id;
        }

        public Builder title(final String title) {
            this.title = title;
            return this;
        }

        public Builder author(final String author) {
            this.author = author;
            return this;
        }

        public Builder introduction(final String introduction) {
            this.introduction = introduction;
            return this;
        }

        public Builder description(final String description) {
            this.description = description;
            return this;
        }

        public Builder creationDate(final Instant creationDate) {
            this.creationDate = creationDate;
            return this;
        }

        public Builder likeCount(final Integer likeCount) {
            this.likeCount = likeCount;
            return this;
        }

        public Builder imageId(final String imageId) {
            this.imageId = imageId;
            return this;
        }

        public CoursePreviewDTO build() throws IllegalStateException {
            return new CoursePreviewDTO(this);
        }
    }
}
