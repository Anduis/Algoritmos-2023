mkdir cases
echo 2 5 4 2 8 2 1 > ./cases/1.in
echo 18 5 4 2 18 2 1 > ./cases/2.in
echo 2 6 2 2 2 2 2 2 > ./cases/3.in
echo 3 6 2 2 2 2 2 2 > ./cases/4.in
echo 2 1 0 > ./cases/5.in
FOR /L %%i IN (1, 1, 5) DO java Main.java < ./cases/%%i.in > ./cases/%%i.out