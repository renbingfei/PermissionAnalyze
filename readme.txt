This project mainly focuses on processing permissions in provided apks and build-in combinations of permissions

It has two functions:
1. using provided apks, calculate how many times these permission-combinations (see com/rbf/model/PermissionCombination.java) appeared in apks.
2. using build-in permission-combinations, calculate how many permissions matched to build-in combinations.

work process:

1. provide absolute folder path of apk files as init parameter to start Main.java
2. After analyzing, in Main.java——>main(), we can get the result.

any questions please contact me: rbf@bupt.edu.cn