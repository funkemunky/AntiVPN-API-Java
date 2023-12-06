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

        @Override
        public T unwrap() throws RuntimeException {
            return getValue();
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

        @Override
        public T unwrap() throws RuntimeException {
            throw new RuntimeException("Attempted to unwrap an error result: " + getError().toString());
        }
    }

    public abstract T unwrap() throws RuntimeException;
}