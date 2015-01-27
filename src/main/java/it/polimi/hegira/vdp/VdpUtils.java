/**
 * Copyright 2014 Marco Scavuzzo
 * Contact: Marco Scavuzzo <marco.scavuzzo@polimi.it>
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 * http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */
/**
 * Utility class for managing Virtual Data Partitions (VDPs)
 * and the keys contained by them.
 */
package it.polimi.hegira.vdp;

import java.util.ArrayList;

/**
 * @author Marco Scavuzzo
 */
public class VdpUtils {

	/**
	 * Calculates the id of the VDP that contains the given element.
	 * @param elemId The id of the element.
	 * @param The power (for the base 10) that allows to calculate the maximum number of VDPs.
	 *
	 * @return Returns the id of the VDP which contains elemId.
	 */
	public static int getVDP(int elemId, int p){
		return elemId / ((int) Math.pow(10,p));
	}
	
	/**
	 * Generates all the elements contained by a VDP (possibly also the erased ones).
	 * @param VDPid The id of the VDP.
	 * @param maxSeq An integer number which represents the maximum sequence number 
	 * inserted by the application.
	 * @param The power (for the base 10) that allows to calculate the maximum number of VDPs.
	 * 
	 * @return An List containing all elements, lower than maxSeq, contained in the VDP bucketId.
	 */
	public static ArrayList<Integer> getElements(int VDPid, int maxSeq, int p){
		Integer maxElems = ((int)Math.pow(10,p));
		ArrayList<Integer> bucket = new ArrayList<Integer>(maxElems.intValue());
		for(int elem = VDPid*maxElems; elem<(VDPid+1)*maxElems && elem <= maxSeq; elem++){
			bucket.add(elem);
		}
		return bucket;
	}
	
	/**
	 * Generates the extremes of the elements contained by a VDP (start, end included!).
	 * @param VDPid The id of the VDP.
	 * @param maxSeq An integer number which represents the maximum sequence number 
	 * inserted by the application.
	 * @param The power (for the base 10) that allows to calculate the maximum number of VDPs.
	 * 
	 * @return An array containing the two extremes of the VDP bucketId.
	 */
	public static int[] getVdpExtremes(int VDPid, int maxSeq, int p){
		Integer maxElems = ((int)Math.pow(10,p));
		int[] extremes = new int[2];
		extremes[0]=VDPid*maxElems;
		int end = ((VDPid+1)*maxElems)-1;
		if(end<maxSeq)
			extremes[1]=end;
		else
			extremes[1]=maxSeq;

		return extremes;
	}
	
	/**
	 * Returns the total number of VDPs for a generic table.
	 * @param maxSeq The total number of element contained by the table.
	 * @param p The power (for the base 10) that allows to calculate the maximum number of VDPs.
	 * @return The total number of VDPs for a generic table.
	 */
	public static int getTotalVDPs(int maxSeq, int p){
		return (int) Math.ceil(maxSeq/Math.pow(10,p));
	}
}
