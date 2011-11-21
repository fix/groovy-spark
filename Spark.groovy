if(args.length<1){
	sleep 300 // piping can take long
	if(System.in.available()){ //needed when you no arg to prevent from hanging
		String sysin=System.in.text
		if(sysin){
			args=sysin.split("\n")
			if(args.length<2){
				args=sysin.split(" ")
			}
		}
	}
}

def sparkit(String[] args){
	double min=Double.MAX_VALUE
	double max=Double.MIN_VALUE
	String sparks = "\u2581\u2582\u2583\u2584\u2585\u2586\u2587\u2588"
	
	def argsnum=args.collect {
		def num = it.toDouble()
		if(num < min) min = num
		if(num > max) max = num
		num
	}
	
	double interval=(max-min)/(sparks.size() - 1)
	
	argsnum.collect {
		sparks[(int) ((it - min) / interval)]
	}.join("")
}

if(args.length==0){
	def example="23 45 9.98 23 76 34 9 1 53 65 23 54 1"
    println "usage: \"spark "+example+"\" would result in " + sparkit(example.split(" "))
}
else {
	println sparkit(args)
}