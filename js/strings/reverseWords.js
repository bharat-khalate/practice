"use strict";
function reverseWords() {
    let str = "I.Love.TS";
    let end = str.length - 1;
    let returnList = [];
    while (end >= 0) {
        while (str[end] == ".") {
            end--;
            continue;
        }
        if (end < 0)
            break;
        let word = "";
        while (end >= 0 && str[end] != ".") {
            word = str[end--] + word;
        }
        if (returnList.length == 0) {
            returnList.push(word);
        }
        else
            returnList.push( word);
    }
    console.log(returnList.join("."));
}
reverseWords()
