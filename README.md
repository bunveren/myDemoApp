made a basic computing method that works with two arrays and merges them with the help of parameters
all the parameters are assumed to be filled with proper types

sortSetting:
---a:ascending
---d:descending
---r:randomize
---j:just concat

duplicateSetting:
---c:care for duplicates(put all of them)
---d:don't care for duplicates(take one in the resulting list only)

errorSetting:
---n: return null for some cases
---s:won't return null ever(for sensitive usages)

transformSetting:
---p: make all elements >=0 (take negative ones' absolute value)
---n: if there are negative ones don't mess with them ,
---s: shrink(divide) with last int

the int parameter div is ignored by default but needs to be filled with an int,
if transformSetting==s then it will be used

https://app.travis-ci.com/bunveren/myDemoApp.svg?token=y4kv32kBRnJCkNoxxhaR&branch=master

Demo site: https://immense-brook-89356-d68ddffc23d7.herokuapp.com/