var twoSum = function(nums, target) {
    let sum = "";
    let counter = 0;
    let array = [];
    while(sum!== null && target !== sum){
        console.log("works");
        for(let i = 0; i < nums.length; i++){
            sum = counter !== i ? nums[counter] + nums[i] : null
            if(sum === target) array = [counter, i] 
            console.log(array);
        }

        counter++;
    }
    return array;    
};

twoSum([0,4,3,0], 0)

