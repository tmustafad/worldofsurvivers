package com.turkmen.survivor.api.model;
/**
 * <h1>The states of the game is defined here. Every game entity or dto has a {@link GameStatus}</h1>
 *
 * @author  Turkmen
 * @see com.turkmen.survivor.entity.GameEntity
 * @see com.turkmen.survivor.entitydto.GameDto
 * @version 1.0
 * @since   2019-01-14
 *
 *
 */
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
