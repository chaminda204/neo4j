package com.chaminda.neo4j.example.api.response;

import java.util.ArrayList;
import java.util.List;

public class JsonResponse<T> {

    private Iterable<T> data;

    private List<JsonError> errors;

    JsonResponse() {

    }

    private JsonResponse(JsonResponseBuilder<T> builder) {
        this.data = builder.data;
        this.errors = builder.errors;
    }

    public Iterable<T> getData() {
        return data;
    }

    public void setData(List<T> data) {
        this.data = data;
    }

    public List<JsonError> getErrors() {
        return errors;
    }

    public void addToErrors(JsonError errors) {
        this.errors.add(errors);
    }

    public static class JsonResponseBuilder<T> {

        private Iterable<T> data;

        private List<JsonError> errors;

        public JsonResponseBuilder<T> withData(Iterable<T> data) {
            this.data = data;
            return this;
        }

        public JsonResponseBuilder<T> withErrors(List<JsonError> errors) {
            this.errors = errors;
            return this;
        }

        public JsonResponseBuilder<T> withError(JsonError error) {
            if (errors == null) {
                errors = new ArrayList<JsonError>();
            }
            this.errors.add(error);
            return this;
        }

        public JsonResponse<T> build() {
            return new JsonResponse<>(this);
        }
    }

}
