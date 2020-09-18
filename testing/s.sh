for((i = 1; ; ++i)); do
    echo $i
    java gen $i > int
    java stupid < int > out1
    java Main < int > out2
    diff -w out1 out2 || break
   #diff -w <( java Main < int) <(java stupid < int) || break
    echo "WA on the following test:"
    cat int
    echo "Your answer is:"
    cat out2
    echo "Correct answer is:"
    cat out1
done

