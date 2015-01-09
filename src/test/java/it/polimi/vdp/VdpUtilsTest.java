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
 * 
 */
package it.polimi.vdp;

import static org.junit.Assert.*;

import java.util.ArrayList;

import org.junit.Test;

/**
 * @author marco
 *
 */
public class VdpUtilsTest {

	/**
	 * Test method for {@link it.polimi.vdp.VdpUtils#getVDP(int, int)}.
	 */
	@Test
	public void testGetVDP() {
		int vdpId = VdpUtils.getVDP(16834, 3);
		assertEquals(16, vdpId);
	}

	/**
	 * Test method for {@link it.polimi.vdp.VdpUtils#getElements(int, int, int)}.
	 */
	@Test
	public void testGetElements() {
		ArrayList<Integer> VDPelements = VdpUtils.getElements(0, 100, 1);
		assertEquals(10, VDPelements.size());
		ArrayList<Integer> desired = new ArrayList<Integer>(10);
		for(int i=0;i<10;i++)
			desired.add(i);
		assertEquals(desired, VDPelements);
	}

	/**
	 * Test method for {@link it.polimi.vdp.VdpUtils#getBucketExtremes(int, int, int)}.
	 */
	@Test
	public void testGetVdpExtremes() {
		int[] vdpExtremes1 = VdpUtils.getVdpExtremes(0, 100, 1);
		int[] dExt1 = {0,9};
		assertArrayEquals(dExt1, vdpExtremes1);
		
		//testing also when maxSeq is less than the maximum VDP size.
		int[] vdpExtremes2 = VdpUtils.getVdpExtremes(1, 15, 1);
		int[] dExt2 = {10,15};
		assertArrayEquals(dExt2, vdpExtremes2);
	}

}
