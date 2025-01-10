
package com.example.SpringbootLeaderBoardSCore.entity;


public enum Badge
{
        CODE_NINJA("Code Ninja"),
        CODE_CHAMP("Code Champ"),
        CODE_MASTER("Code Master");
        private final String message;
        
        Badge(String message)
        {
                this.message=message;

        }

        public String getMessage()
        {
                return message;
        }
}

