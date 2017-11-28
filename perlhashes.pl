#!/bin/perl

my @names = ("box_TGPROD_CSS_gas_odour_rpt                                     09/18/2009 06:10:00  09/18/2009 06:36:52  SU 634449/1","box_TGPROD_CSS_meter_exchanges_rpt                               09/18/2009 06:10:00  09/18/2009 09:30:32  SU 635198/1","box_TGPROD_DP_monitoring                                         09/17/2009 20:40:17  09/18/2009 04:06:37  OH 632953/1","box_TGPROD_Davox_extract                                         09/18/2009 09:45:00  09/18/2009 09:49:49  SU 635318/1","box_TGPROD_Davox_upload                                          09/18/2009 19:20:00  09/18/2009 19:32:05  SU 637661/1","box_TGPROD_EPP_review                                            09/12/2009 08:19:57  09/12/2009 13:04:04  SU 603642/1","box_TGPROD_IB_adjusted_usage                                     09/18/2009 08:02:00  09/18/2009 08:02:31  SU 634879/1","box_TGPROD_IB_allocations                                        09/18/2009 18:00:00  09/18/2009 18:02:03  SU 637351/1","box_TGPROD_IB_health_reports                                     09/18/2009 08:00:00  09/18/2009 08:01:11  SU 634869/1");
my %jobhash=();

foreach (@names) {
	my ($jname,$start,$stime,$end,$etime,$status,$idn) = split /\s+/, $_;	
	#print $datestr;
	#print " ";
	#print $jname;
	print $jname." ".$start." ".$stime;
	print "\n";
	my $key=$start." ".$stime;
	print $key;
	print "\n";
	# chomp($datestr);
	if(exists($jobhash{$key})){
	    print "Exists \n";
	    $jobhash{$key}=$jobhash{$key}."|".$jname;		
	} else {
	    print "not exists \n";
	    $jobhash{$key}=$jname;	
	}
}
print "\n";
# my @data = keys %jobhash;
# print @data;

my @finalJobarray;
foreach my $jobdatekey (sort keys %jobhash) {
    #printf "%-8s %s\n", $name, $jobhash{$jobdatekey};
    my @jobs = split /\|+/, $jobhash{$jobdatekey};
    foreach (@jobs){
            push @finalJobarray, $_;
    }
    print "\n";
}

foreach (@finalJobarray){
        printf "%s \n",$_;
}
# %people = ();
# $people{"Fred"} = "Flinstone";
# $people{"Barney"} = "Rubble";

# # specify the desired key
# $key = "Fr";

# if (exists($people{$key}))
# {
  # # if the key is found in the hash come here
  # print "Found Fred\n";
# }
# else
# {
  # # come here if the key is not found in the hash
  # print "Could not find Fred\n";
# }
