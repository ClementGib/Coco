package com.cdx.coco.domain.category;

import net.dv8tion.jda.api.MessageBuilder;

public record Category(String name, String description) {

    private Category(Builder builder) {
        this(builder.name, builder.description);
    }

    public static class Builder {
        private String name;
        private String description;

        public Builder(final String name) {
            this.name = name;
        }

        public Builder description(final String description) {
            this.description = description;
            return this;
        }

        public Category build() throws IllegalStateException {
            validate();
            return new Category(this);
        }

        private void validate() throws IllegalStateException {
            MessageBuilder messageBuilder = new MessageBuilder();

            if (name == null) {
                messageBuilder.append("Id must not be null.");
            } else if (name.length() > 255) {
                messageBuilder.append("Title cannot have more than 100 characters.");
            }

            if (description == null) {
                messageBuilder.append("Description must not be null.");
            } else if (description != null && description.length() < 50) {
                messageBuilder.append("Description cannot be null and have less than 50 characters.");
            }
        }
    }
}
