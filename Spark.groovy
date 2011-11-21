if(args.length==0){
	def sysin=System.in.text
	if(sysin){
		args=sysin.split(" ");
		if(args.length<2){
			args=sysin.split("/n");
		}
	}
}
if(args.length==0) println "usage: groovy spark 0 4 35 7 9 ..."
else {
	String sparks = "▁▂▃▄▅▆▇"
	def min=Double.MAX_VALUE
	def max=Double.MIN_VALUE
	output=""
	args.each{
		//println it
		double candidate = it.toDouble()
		if(candidate < min) min= candidate
		if (candidate > max) max = candidate
	}

	double interval=(max-min)/(sparks.size() - 1)

	args.each{
		double candidate = it.toDouble()
		int sparkIndex = (int) ((candidate - min) / interval);
		output+=sparks[sparkIndex]
	}

	println output
}