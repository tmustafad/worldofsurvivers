package com.turkmen.survivor.api.model;

public enum GameStatus {
        NEW(3),ACTIVE(1),PAUSED(0),WIN(2),LOST(-1);
        private int code;

        GameStatus(int code){
                this.code=code;
        }

        public int getCode() {
                return code;
        }

        public void setCode(int code) {
                this.code = code;
        }
}
