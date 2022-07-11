package com.cdx.coco.domain.course;

import java.time.Instant;

import net.dv8tion.jda.api.MessageBuilder;



/**
 * Reduced course with just the preview informations
 * 
 */
public record CoursePreview(Integer id, 
        String title, 
        String author, 
        String introduction, 
        String description,
        Instant creationDate, 
        Integer likeCount, 
        String imageId) {

    private CoursePreview(Builder builder) {
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

        public CoursePreview build() throws IllegalStateException {
            validate();
            return new CoursePreview(this);
        }

        private void validate() throws IllegalStateException {
            MessageBuilder messageBuilder = new MessageBuilder();

            if (id == null) {
                messageBuilder.append("Id must not be null.");
            } else if (id <= 0) {
                messageBuilder.append("Id must be numeric and greater than 0");
            }

            if (title == null) {
                messageBuilder.append("Title must not be null.");
            } else if (title.length() < 2) {
                messageBuilder.append("Title must have at least 2 characters.");
            } else if (title.length() > 255) {
                messageBuilder.append("Title cannot have more than 100 characters.");
            }

            if (author == null) {
                messageBuilder.append("Author must not be null.");
            } else if (author != null && author.length() > 50) {
                messageBuilder.append("Author cannot have more than 50 characters.");
            }

            if (introduction == null) {
                messageBuilder.append("Introduction must not be null.");
            } else if (introduction != null && introduction.length() > 50) {
                messageBuilder.append("Introduction cannot be null and have more than 50 characters.");
            }

            if (description == null) {
                messageBuilder.append("Description must not be null.");
            } else if (description != null && description.length() < 50) {
                messageBuilder.append("Description cannot be null and have less than 50 characters.");
            }

            if (creationDate == null) {
                messageBuilder.append("creation date must not be null.");
            }

            if (likeCount == null) {
                messageBuilder.append("like count must not be null.");
            } else if (likeCount < 0) {
                messageBuilder.append("like count must be numeric and equals or greater than 0");
            }

            if (messageBuilder.length() > 0) {
                throw new IllegalStateException(messageBuilder.toString());
            }
        }
    }
}
