package dev.brighten.isitbad.utils;

public abstract class Result<T, E> {
    private Result() {}

    public static final class Ok<T, E> extends Result<T, E> {
        private final T value;

        public Ok(T value) {
            this.value = value;
        }

        public T getValue() {
            return value;
        }
    }

    public static final class Err<T, E> extends Result<T, E> {
        private final E error;

        public Err(E error) {
            this.error = error;
        }

        public E getError() {
            return error;
        }
    }
}