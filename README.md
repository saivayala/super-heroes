# capstone-super-heroes

## Project Overview
In this project, which will display heroes on recycler view and 
details of the hero will be displayed when on click on it

## Why this Project

This is build to provide a good interface to the kids and 
the users who are intreasted on super heroes

##Super heroes
Visit the site for api [Super Heroes](https://www.superheroapi.com/)
<section>
					<h2 id="api-references"><a href="#api-references">API References</a></h2>

					<div class="code-preview"><pre><span class="language-name" id="language-naam"></span><span class="language-name">BASE URL</span>https://superheroapi.com/api/<kbd>access-token</kbd></pre></div>

					<div class="dir-explain">
						<code class="url">/id</code>
						<ul class="files">
							<li><code>/powerstats</code></li>
							<li><code>/biography</code></li>
							<li><code>/appearance</code></li>
							<li><code>/work</code></li>
							<li><code>/connections</code></li>
							<li><code>/image</code></li>
						</ul>
						<code class="url">/search/name</code>
					</div>
					<div class="table-responsive">
						<table class="table table-bordered table-striped">
							<thead>
								<tr>
									<th>Reference</th>
									<th>Method</th>
									<th>Purpose</th>
								</tr>
							</thead>
							<tbody>
								<tr>
									<td><code>/id</code></td>
									<td>GET</td>
									<td>Search by <a>character id</a>. Returns all information of the character.</td>
								</tr>
								<tr>
									<td><code>/id/powerstats</code></td>
									<td>GET</td>
									<td>Returns JSON Array of all powerstats of given character.</td>
								</tr>
								<tr>
									<td><code>/id/biography</code></td>
									<td>GET</td>
									<td>Returns JSON Array of character's biography.</td>
								</tr>
								<tr>
									<td><code>/id/appearance</code></td>
									<td>GET</td>
									<td>Returns JSON Array of character's appearance.</td>
								</tr>
								<tr>
									<td><code>/id/work</code></td>
									<td>GET</td>
									<td>Returns JSON Array of character's work i.e. occupation and operation base.</td>
								</tr>
								<tr>
									<td><code>/id/connections</code></td>
									<td>GET</td>
									<td>Returns JSON Array of character's connections.</td>
								</tr>
								<tr>
									<td><code>/id/image</code></td>
									<td>GET</td>
									<td>Returns image url of the character.</td>
								</tr>
								<tr>
									<td><code>/name</code></td>
									<td>GET</td>
									<td>Search character by name. Returns character id.</td>
								</tr>
							</tbody>
						</table>
					</div>

					<h3 id="id"><a href="#id">/id</a></h3>
						<div class="code-tabs"><div class="languages"><div class="btn-group" data-toggle="buttons"><label class="btn active"><input type="radio" autocomplete="off" checked="">Example</label><label class="btn"><input type="radio" autocomplete="off"> json</label></div></div>
							<div class="window-content"><div class="code-preview">Sample Call Reference:<br>
								<div class="prism-show-language"><div class="prism-show-language-label">HTTP</div></div><pre class="line-numbers language-http"><span class="language-name" id="language-naam"> http</span><code class=" language-http"><span class="token header-name keyword">https:</span>//superheroapi.com/api/access-token/character-id<span aria-hidden="true" class="line-numbers-rows"><span></span></span></code></pre>
							</div><div class="prism-show-language" style="display: none;"><div class="prism-show-language-label">JSON</div></div><pre class="line-numbers pre-scrollable language-json" style="display: none;"><span class="language-name" id="language-naam"> json</span><a class="btn btn-sm btn-purple clipboard-copy" id="copy-button" data-original-title="Copied!">Copy</a><code class=" language-json"><span class="token punctuation">{</span>
  <span class="token property">"response"</span><span class="token operator">:</span> <span class="token string">"success"</span><span class="token punctuation">,</span>
  <span class="token property">"id"</span><span class="token operator">:</span> <span class="token string">"70"</span><span class="token punctuation">,</span>
  <span class="token property">"name"</span><span class="token operator">:</span> <span class="token string">"Batman"</span><span class="token punctuation">,</span>
  <span class="token property">"powerstats"</span><span class="token operator">:</span> <span class="token punctuation">{</span>
    <span class="token property">"intelligence"</span><span class="token operator">:</span> <span class="token string">"100"</span><span class="token punctuation">,</span>
    <span class="token property">"strength"</span><span class="token operator">:</span> <span class="token string">"26"</span><span class="token punctuation">,</span>
    <span class="token property">"speed"</span><span class="token operator">:</span> <span class="token string">"27"</span><span class="token punctuation">,</span>
    <span class="token property">"durability"</span><span class="token operator">:</span> <span class="token string">"50"</span><span class="token punctuation">,</span>
    <span class="token property">"power"</span><span class="token operator">:</span> <span class="token string">"47"</span><span class="token punctuation">,</span>
    <span class="token property">"combat"</span><span class="token operator">:</span> <span class="token string">"100"</span>
  <span class="token punctuation">}</span><span class="token punctuation">,</span>
  <span class="token property">"biography"</span><span class="token operator">:</span> <span class="token punctuation">{</span>
    <span class="token property">"full-name"</span><span class="token operator">:</span> <span class="token string">"Bruce Wayne"</span><span class="token punctuation">,</span>
    <span class="token property">"alter-egos"</span><span class="token operator">:</span> <span class="token string">"No alter egos found."</span><span class="token punctuation">,</span>
    <span class="token property">"aliases"</span><span class="token operator">:</span> <span class="token punctuation">[</span>
      <span class="token string">"Insider"</span><span class="token punctuation">,</span>
      <span class="token string">"Matches Malone"</span>
    <span class="token punctuation">]</span><span class="token punctuation">,</span>
    <span class="token property">"place-of-birth"</span><span class="token operator">:</span> <span class="token string">"Crest Hill, Bristol Township; Gotham County"</span><span class="token punctuation">,</span>
    <span class="token property">"first-appearance"</span><span class="token operator">:</span> <span class="token string">"Detective Comics #27"</span><span class="token punctuation">,</span>
    <span class="token property">"publisher"</span><span class="token operator">:</span> <span class="token string">"DC Comics"</span><span class="token punctuation">,</span>
    <span class="token property">"alignment"</span><span class="token operator">:</span> <span class="token string">"good"</span>
  <span class="token punctuation">}</span><span class="token punctuation">,</span>
  <span class="token property">"appearance"</span><span class="token operator">:</span> <span class="token punctuation">{</span>
    <span class="token property">"gender"</span><span class="token operator">:</span> <span class="token string">"Male"</span><span class="token punctuation">,</span>
    <span class="token property">"race"</span><span class="token operator">:</span> <span class="token string">"Human"</span><span class="token punctuation">,</span>
    <span class="token property">"height"</span><span class="token operator">:</span> <span class="token punctuation">[</span>
      <span class="token string">"6'2"</span><span class="token punctuation">,</span>
      <span class="token string">"188 cm"</span>
    <span class="token punctuation">]</span><span class="token punctuation">,</span>
    <span class="token property">"weight"</span><span class="token operator">:</span> <span class="token punctuation">[</span>
      <span class="token string">"210 lb"</span><span class="token punctuation">,</span>
      <span class="token string">"95 kg"</span>
    <span class="token punctuation">]</span><span class="token punctuation">,</span>
    <span class="token property">"eye-color"</span><span class="token operator">:</span> <span class="token string">"blue"</span><span class="token punctuation">,</span>
    <span class="token property">"hair-color"</span><span class="token operator">:</span> <span class="token string">"black"</span>
  <span class="token punctuation">}</span><span class="token punctuation">,</span>
  <span class="token property">"work"</span><span class="token operator">:</span> <span class="token punctuation">{</span>
    <span class="token property">"occupation"</span><span class="token operator">:</span> <span class="token string">"Businessman"</span><span class="token punctuation">,</span>
    <span class="token property">"base"</span><span class="token operator">:</span> <span class="token string">"Batcave, Stately Wayne Manor, Gotham City; Hall of Justice, Justice League Watchtower"</span>
  <span class="token punctuation">}</span><span class="token punctuation">,</span>
  <span class="token property">"connections"</span><span class="token operator">:</span> <span class="token punctuation">{</span>
    <span class="token property">"group-affiliation"</span><span class="token operator">:</span> <span class="token string">"Batman Family, Batman Incorporated, Justice League, Outsiders, Wayne Enterprises, Club of Heroes, formerly White Lantern Corps, Sinestro Corps"</span><span class="token punctuation">,</span>
    <span class="token property">"relatives"</span><span class="token operator">:</span> <span class="token string">"Damian Wayne (son), Dick Grayson (adopted son), Tim Drake (adopted son), Jason Todd (adopted son), Cassandra Cain (adopted ward)\nMartha Wayne (mother, deceased), Thomas Wayne (father, deceased), Alfred Pennyworth (former guardian), Roderick Kane (grandfather, deceased), Elizabeth Kane (grandmother, deceased), Nathan Kane (uncle, deceased), Simon Hurt (ancestor), Wayne Family"</span>
  <span class="token punctuation">}</span><span class="token punctuation">,</span>
  <span class="token property">"image"</span><span class="token operator">:</span> <span class="token punctuation">{</span>
    <span class="token property">"url"</span><span class="token operator">:</span> <span class="token string">"httpss://www.superherodb.com/pictures2/portraits/10/100/639.jpg"</span>
  <span class="token punctuation">}</span>
<span class="token punctuation">}</span><span aria-hidden="true" class="line-numbers-rows"><span></span><span></span><span></span><span></span><span></span><span></span><span></span><span></span><span></span><span></span><span></span><span></span><span></span><span></span><span></span><span></span><span></span><span></span><span></span><span></span><span></span><span></span><span></span><span></span><span></span><span></span><span></span><span></span><span></span><span></span><span></span><span></span><span></span><span></span><span></span><span></span><span></span><span></span><span></span><span></span><span></span><span></span><span></span><span></span><span></span><span></span><span></span><span></span><span></span><span></span></span></code></pre></div>
							
				</div>
				<p>You can find the character ids <a href="ids.html">here</a>.</p>
					<h3 id="powerstats"><a href="#powerstats">/id/powerstats</a></h3>
					<p>This API call provides all powerstats for the given character. The powerstats are as follows :-
					</p><ul>
						<li>
							Intelligence
						</li>
						<li>
							Strength
						</li>
						<li>
							Speed
						</li>
						<li>
							Durability
						</li>
						<li>
							Power
						</li>
						<li>
							Combat
						</li>
					</ul>
					<p></p>
					<div class="code-tabs"><div class="languages"><div class="btn-group" data-toggle="buttons"><label class="btn active"><input type="radio" autocomplete="off" checked="">Example</label><label class="btn"><input type="radio" autocomplete="off"> json</label></div></div>
							<div class="window-content"><div class="code-preview">Sample Call Reference:<br>
								<div class="prism-show-language"><div class="prism-show-language-label">HTTP</div></div><pre class="line-numbers language-http"><span class="language-name" id="language-naam"> http</span><code class=" language-http"><span class="token header-name keyword">https:</span>//superheroapi.com/api/access-token/character-id/powerstats<span aria-hidden="true" class="line-numbers-rows"><span></span></span></code></pre>
							</div><div class="prism-show-language" style="display: none;"><div class="prism-show-language-label">JSON</div></div><pre class="line-numbers pre-scrollable language-json" style="display: none;"><span class="language-name" id="language-naam"> json</span><a class="btn btn-sm btn-purple clipboard-copy" id="copy-button" data-original-title="Copied!">Copy</a><code class=" language-json"><span class="token punctuation">{</span>
  <span class="token property">"response"</span><span class="token operator">:</span> <span class="token string">"success"</span><span class="token punctuation">,</span>
  <span class="token property">"id"</span><span class="token operator">:</span> <span class="token string">"70"</span><span class="token punctuation">,</span>
  <span class="token property">"name"</span><span class="token operator">:</span> <span class="token string">"Batman"</span><span class="token punctuation">,</span>
  <span class="token property">"intelligence"</span><span class="token operator">:</span> <span class="token string">"100"</span><span class="token punctuation">,</span>
  <span class="token property">"strength"</span><span class="token operator">:</span> <span class="token string">"26"</span><span class="token punctuation">,</span>
  <span class="token property">"speed"</span><span class="token operator">:</span> <span class="token string">"27"</span><span class="token punctuation">,</span>
  <span class="token property">"durability"</span><span class="token operator">:</span> <span class="token string">"50"</span><span class="token punctuation">,</span>
  <span class="token property">"power"</span><span class="token operator">:</span> <span class="token string">"47"</span><span class="token punctuation">,</span>
  <span class="token property">"combat"</span><span class="token operator">:</span> <span class="token string">"100"</span>
<span class="token punctuation">}</span><span aria-hidden="true" class="line-numbers-rows"><span></span><span></span><span></span><span></span><span></span><span></span><span></span><span></span><span></span><span></span><span></span></span></code></pre></div>
							
						</div>

					<h3 id="biography"><a href="#biography">/id/biography</a></h3>
					<p>This API call gives the biographical stats of the character. They are :
						</p><li>
							Full Name
						</li>
						<li>
							Alter Egos
						</li>
						<li>
							Aliases
						</li>
						<li>
							Place of Birth
						</li>
						<li>
							First Appearance
						</li>
						<li>
							Publisher
						</li>
						<li>
							Alignment
						</li>
					
					<p></p>
					<div class="code-tabs"><div class="languages"><div class="btn-group" data-toggle="buttons"><label class="btn active"><input type="radio" autocomplete="off" checked="">Example</label><label class="btn"><input type="radio" autocomplete="off"> json</label></div></div>

							<div class="window-content"><div class="code-preview">Sample Call Reference:<br>
								<div class="prism-show-language"><div class="prism-show-language-label">HTTP</div></div><pre class="line-numbers language-http"><span class="language-name" id="language-naam"> http</span><code class=" language-http"><span class="token header-name keyword">https:</span>//superheroapi.com/api/access-token/character-id/biography<span aria-hidden="true" class="line-numbers-rows"><span></span></span></code></pre>
							</div><div class="prism-show-language" style="display: none;"><div class="prism-show-language-label">JSON</div></div><pre class="line-numbers pre-scrollable language-json" style="display: none;"><span class="language-name" id="language-naam"> json</span><a class="btn btn-sm btn-purple clipboard-copy" id="copy-button" data-original-title="Copied!">Copy</a><code class=" language-json"><span class="token punctuation">{</span>
  <span class="token property">"response"</span><span class="token operator">:</span> <span class="token string">"success"</span><span class="token punctuation">,</span>
  <span class="token property">"id"</span><span class="token operator">:</span> <span class="token string">"70"</span><span class="token punctuation">,</span>
  <span class="token property">"name"</span><span class="token operator">:</span> <span class="token string">"Batman"</span><span class="token punctuation">,</span>
  <span class="token property">"full-name"</span><span class="token operator">:</span> <span class="token string">"Bruce Wayne"</span><span class="token punctuation">,</span>
  <span class="token property">"alter-egos"</span><span class="token operator">:</span> <span class="token string">"No alter egos found."</span><span class="token punctuation">,</span>
  <span class="token property">"aliases"</span><span class="token operator">:</span> <span class="token punctuation">[</span>
    <span class="token string">"Insider"</span><span class="token punctuation">,</span>
    <span class="token string">"Matches Malone"</span>
  <span class="token punctuation">]</span><span class="token punctuation">,</span>
  <span class="token property">"place-of-birth"</span><span class="token operator">:</span> <span class="token string">"Crest Hill, Bristol Township; Gotham County"</span><span class="token punctuation">,</span>
  <span class="token property">"first-appearance"</span><span class="token operator">:</span> <span class="token string">"Detective Comics #27"</span><span class="token punctuation">,</span>
  <span class="token property">"publisher"</span><span class="token operator">:</span> <span class="token string">"DC Comics"</span><span class="token punctuation">,</span>
  <span class="token property">"alignment"</span><span class="token operator">:</span> <span class="token string">"good"</span>
<span class="token punctuation">}</span><span aria-hidden="true" class="line-numbers-rows"><span></span><span></span><span></span><span></span><span></span><span></span><span></span><span></span><span></span><span></span><span></span><span></span><span></span><span></span><span></span></span></code></pre></div>
							
						</div>

					<h3 id="appearance"><a href="#appearance">/id/appearance</a></h3>
					<p>This API call provides the appearance of the character. The various statistics are :
					</p><ul>
						<li>
							Gender
						</li>
						<li>
							Race
						</li>
						<li>
							Height
						</li>
						<li>
							Weight
						</li>
						<li>
							Eye Color
						</li>
						<li>
							Hair Color
						</li>
					</ul>
					<p></p>
					<div class="code-tabs"><div class="languages"><div class="btn-group" data-toggle="buttons"><label class="btn active"><input type="radio" autocomplete="off" checked="">Example</label><label class="btn"><input type="radio" autocomplete="off"> json</label></div></div>
							<div class="window-content"><div class="code-preview">Sample Call Reference:<br>
								<div class="prism-show-language"><div class="prism-show-language-label">HTTP</div></div><pre class="line-numbers language-http"><span class="language-name" id="language-naam"> http</span><code class=" language-http"><span class="token header-name keyword">https:</span>//superheroapi.com/api/access-token/character-id/appearance<span aria-hidden="true" class="line-numbers-rows"><span></span></span></code></pre>
							</div><div class="prism-show-language" style="display: none;"><div class="prism-show-language-label">JSON</div></div><pre class="line-numbers pre-scrollable language-json" style="display: none;"><span class="language-name" id="language-naam"> json</span><a class="btn btn-sm btn-purple clipboard-copy" id="copy-button" data-original-title="Copied!">Copy</a><code class=" language-json"><span class="token punctuation">{</span>
  <span class="token property">"response"</span><span class="token operator">:</span> <span class="token string">"success"</span><span class="token punctuation">,</span>
  <span class="token property">"id"</span><span class="token operator">:</span> <span class="token string">"70"</span><span class="token punctuation">,</span>
  <span class="token property">"name"</span><span class="token operator">:</span> <span class="token string">"Batman"</span><span class="token punctuation">,</span>
  <span class="token property">"gender"</span><span class="token operator">:</span> <span class="token string">"Male"</span><span class="token punctuation">,</span>
  <span class="token property">"race"</span><span class="token operator">:</span> <span class="token string">"Human"</span><span class="token punctuation">,</span>
  <span class="token property">"height"</span><span class="token operator">:</span> <span class="token punctuation">[</span>
    <span class="token string">"6'2"</span><span class="token punctuation">,</span>
    <span class="token string">"188 cm"</span>
  <span class="token punctuation">]</span><span class="token punctuation">,</span>
  <span class="token property">"weight"</span><span class="token operator">:</span> <span class="token punctuation">[</span>
    <span class="token string">"210 lb"</span><span class="token punctuation">,</span>
    <span class="token string">"95 kg"</span>
  <span class="token punctuation">]</span><span class="token punctuation">,</span>
  <span class="token property">"eye-color"</span><span class="token operator">:</span> <span class="token string">"blue"</span><span class="token punctuation">,</span>
  <span class="token property">"hair-color"</span><span class="token operator">:</span> <span class="token string">"black"</span>
<span class="token punctuation">}</span><span aria-hidden="true" class="line-numbers-rows"><span></span><span></span><span></span><span></span><span></span><span></span><span></span><span></span><span></span><span></span><span></span><span></span><span></span><span></span><span></span><span></span><span></span></span></code></pre></div>
							
						</div>

					<h3 id="work"><a href="#work">/id/work</a></h3>
					<p>This API lists the work/occupation of the character. They are:
					</p><ul>
						<li>
							Occupation
						</li>
						<li>
							Base of operation
							</li>
						</ul>
					<p></p>
					<div class="code-tabs"><div class="languages"><div class="btn-group" data-toggle="buttons"><label class="btn active"><input type="radio" autocomplete="off" checked="">Example</label><label class="btn"><input type="radio" autocomplete="off"> json</label></div></div>
							<div class="window-content"><div class="code-preview">Sample Call Reference:<br>
								<div class="prism-show-language"><div class="prism-show-language-label">HTTP</div></div><pre class="line-numbers language-http"><span class="language-name" id="language-naam"> http</span><code class=" language-http"><span class="token header-name keyword">https:</span>//superheroapi.com/api/access-token/character-id/work<span aria-hidden="true" class="line-numbers-rows"><span></span></span></code></pre>
							</div><div class="prism-show-language" style="display: none;"><div class="prism-show-language-label">JSON</div></div><pre class="line-numbers pre-scrollable language-json" style="display: none;"><span class="language-name" id="language-naam"> json</span><a class="btn btn-sm btn-purple clipboard-copy" id="copy-button" data-original-title="Copied!">Copy</a><code class=" language-json"><span class="token punctuation">{</span>
  <span class="token property">"response"</span><span class="token operator">:</span> <span class="token string">"success"</span><span class="token punctuation">,</span>
  <span class="token property">"id"</span><span class="token operator">:</span> <span class="token string">"70"</span><span class="token punctuation">,</span>
  <span class="token property">"name"</span><span class="token operator">:</span> <span class="token string">"Batman"</span><span class="token punctuation">,</span>
  <span class="token property">"occupation"</span><span class="token operator">:</span> <span class="token string">"Businessman"</span><span class="token punctuation">,</span>
  <span class="token property">"base"</span><span class="token operator">:</span> <span class="token string">"Batcave, Stately Wayne Manor, Gotham City; Hall of Justice, Justice League Watchtower"</span>
<span class="token punctuation">}</span><span aria-hidden="true" class="line-numbers-rows"><span></span><span></span><span></span><span></span><span></span><span></span><span></span></span></code></pre></div>
							
						</div>

					<h3 id="connections"><a href="#connections">/id/connections</a></h3>
					<p>This call lists out the connections of the character.
					</p><ul>
						<li>
							Group Affiliation
						</li>
						<li>
							Relatives
						</li>
					</ul>
					<p></p>
					<div class="code-tabs"><div class="languages"><div class="btn-group" data-toggle="buttons"><label class="btn active"><input type="radio" autocomplete="off" checked="">Example</label><label class="btn"><input type="radio" autocomplete="off"> json</label></div></div>
							<div class="window-content"><div class="code-preview">Sample Call Reference:<br>
								<div class="prism-show-language"><div class="prism-show-language-label">HTTP</div></div><pre class="line-numbers language-http"><span class="language-name" id="language-naam"> http</span><code class=" language-http"><span class="token header-name keyword">https:</span>//superheroapi.com/api/access-token/character-id/connections<span aria-hidden="true" class="line-numbers-rows"><span></span></span></code></pre>
							</div><div class="prism-show-language" style="display: none;"><div class="prism-show-language-label">JSON</div></div><pre class="line-numbers pre-scrollable language-json" style="display: none;"><span class="language-name" id="language-naam"> json</span><a class="btn btn-sm btn-purple clipboard-copy" id="copy-button" data-original-title="Copied!">Copy</a><code class=" language-json"><span class="token punctuation">{</span>
  <span class="token property">"response"</span><span class="token operator">:</span> <span class="token string">"success"</span><span class="token punctuation">,</span>
  <span class="token property">"id"</span><span class="token operator">:</span> <span class="token string">"70"</span><span class="token punctuation">,</span>
  <span class="token property">"name"</span><span class="token operator">:</span> <span class="token string">"Batman"</span><span class="token punctuation">,</span>
  <span class="token property">"group-affiliation"</span><span class="token operator">:</span> <span class="token string">"Batman Family, Batman Incorporated, Justice League, Outsiders, Wayne Enterprises, Club of Heroes, formerly White Lantern Corps, Sinestro Corps"</span><span class="token punctuation">,</span>
  <span class="token property">"relatives"</span><span class="token operator">:</span> <span class="token string">"Damian Wayne (son), Dick Grayson (adopted son), Tim Drake (adopted son), Jason Todd (adopted son), Cassandra Cain (adopted ward)\nMartha Wayne (mother, deceased), Thomas Wayne (father, deceased), Alfred Pennyworth (former guardian), Roderick Kane (grandfather, deceased), Elizabeth Kane (grandmother, deceased), Nathan Kane (uncle, deceased), Simon Hurt (ancestor), Wayne Family"</span>
<span class="token punctuation">}</span><span aria-hidden="true" class="line-numbers-rows"><span></span><span></span><span></span><span></span><span></span><span></span><span></span></span></code></pre></div>
							
						</div>

					<h3 id="image"><a href="#image">/id/image</a></h3>
					<p>This provides the image for the character, if exists.
					</p><ul>
						<li>
							image
						</li>
						
					</ul>
					<p></p>
					<div class="code-tabs"><div class="languages"><div class="btn-group" data-toggle="buttons"><label class="btn active"><input type="radio" autocomplete="off" checked="">Example</label><label class="btn"><input type="radio" autocomplete="off"> json</label></div></div>
							<div class="window-content"><div class="code-preview">Sample Call Reference:<br>
								<div class="prism-show-language"><div class="prism-show-language-label">HTTP</div></div><pre class="line-numbers language-http"><span class="language-name" id="language-naam"> http</span><code class=" language-http"><span class="token header-name keyword">https:</span>//superheroapi.com/api/access-token/character-id/image<span aria-hidden="true" class="line-numbers-rows"><span></span></span></code></pre>
							</div><div class="prism-show-language" style="display: none;"><div class="prism-show-language-label">JSON</div></div><pre class="line-numbers pre-scrollable language-json" style="display: none;"><span class="language-name" id="language-naam"> json</span><a class="btn btn-sm btn-purple clipboard-copy" id="copy-button" data-original-title="Copied!">Copy</a><code class=" language-json"><span class="token punctuation">{</span>
  <span class="token property">"response"</span><span class="token operator">:</span> <span class="token string">"success"</span><span class="token punctuation">,</span>
  <span class="token property">"id"</span><span class="token operator">:</span> <span class="token string">"70"</span><span class="token punctuation">,</span>
  <span class="token property">"name"</span><span class="token operator">:</span> <span class="token string">"Batman"</span><span class="token punctuation">,</span>
  <span class="token property">"url"</span><span class="token operator">:</span> <span class="token string">"https://www.superherodb.com/pictures2/portraits/10/100/639.jpg"</span>
<span class="token punctuation">}</span><span aria-hidden="true" class="line-numbers-rows"><span></span><span></span><span></span><span></span><span></span><span></span></span></code></pre></div>
							
						</div>

					<h3 id="name"><a href="#name">/search/name</a></h3>
					<p>This API call helps you in finding the character-id of a character by searching it's name.</p>
					<div class="code-tabs"><div class="languages"><div class="btn-group" data-toggle="buttons"><label class="btn active"><input type="radio" autocomplete="off" checked="">Example</label><label class="btn"><input type="radio" autocomplete="off"> json</label></div></div>
							<div class="window-content"><div class="code-preview">Sample Call Reference:<br>
								<div class="prism-show-language"><div class="prism-show-language-label">HTTP</div></div><pre class="line-numbers language-http"><span class="language-name" id="language-naam"> http</span><code class=" language-http"><span class="token header-name keyword">https:</span>//superheroapi.com/api/access-token/search/name<span aria-hidden="true" class="line-numbers-rows"><span></span></span></code></pre>
							</div><div class="prism-show-language" style="display: none;"><div class="prism-show-language-label">JSON</div></div><pre class="line-numbers pre-scrollable language-json" style="display: none;"><span class="language-name" id="language-naam"> json</span><a class="btn btn-sm btn-purple clipboard-copy" id="copy-button" data-original-title="Copied!">Copy</a><code class=" language-json"><span class="token punctuation">{</span>
  <span class="token property">"response"</span><span class="token operator">:</span> <span class="token string">"success"</span><span class="token punctuation">,</span>
  <span class="token property">"results-for"</span><span class="token operator">:</span> <span class="token string">"batman"</span><span class="token punctuation">,</span>
  <span class="token property">"results"</span><span class="token operator">:</span> <span class="token punctuation">[</span>
    <span class="token punctuation">{</span>
      <span class="token property">"id"</span><span class="token operator">:</span> <span class="token string">"69"</span><span class="token punctuation">,</span>
      <span class="token property">"name"</span><span class="token operator">:</span> <span class="token string">"Batman"</span><span class="token punctuation">,</span>
      <span class="token property">"powerstats"</span><span class="token operator">:</span> <span class="token punctuation">{</span>
        <span class="token property">"intelligence"</span><span class="token operator">:</span> <span class="token string">"81"</span><span class="token punctuation">,</span>
        <span class="token property">"strength"</span><span class="token operator">:</span> <span class="token string">"40"</span><span class="token punctuation">,</span>
        <span class="token property">"speed"</span><span class="token operator">:</span> <span class="token string">"29"</span><span class="token punctuation">,</span>
        <span class="token property">"durability"</span><span class="token operator">:</span> <span class="token string">"55"</span><span class="token punctuation">,</span>
        <span class="token property">"power"</span><span class="token operator">:</span> <span class="token string">"63"</span><span class="token punctuation">,</span>
        <span class="token property">"combat"</span><span class="token operator">:</span> <span class="token string">"90"</span>
      <span class="token punctuation">}</span><span class="token punctuation">,</span>
      <span class="token property">"biography"</span><span class="token operator">:</span> <span class="token punctuation">{</span>
        <span class="token property">"full-name"</span><span class="token operator">:</span> <span class="token string">"Terry McGinnis"</span><span class="token punctuation">,</span>
        <span class="token property">"alter-egos"</span><span class="token operator">:</span> <span class="token string">"No alter egos found."</span><span class="token punctuation">,</span>
        <span class="token property">"aliases"</span><span class="token operator">:</span> <span class="token punctuation">[</span>
          <span class="token string">"Batman II"</span><span class="token punctuation">,</span>
          <span class="token string">"The Tomorrow Knight"</span><span class="token punctuation">,</span>
          <span class="token string">"The second Dark Knight"</span><span class="token punctuation">,</span>
          <span class="token string">"The Dark Knight of Tomorrow"</span><span class="token punctuation">,</span>
          <span class="token string">"Batman Beyond"</span>
        <span class="token punctuation">]</span><span class="token punctuation">,</span>
        <span class="token property">"place-of-birth"</span><span class="token operator">:</span> <span class="token string">"Gotham City, 25th Century"</span><span class="token punctuation">,</span>
        <span class="token property">"first-appearance"</span><span class="token operator">:</span> <span class="token string">"Batman Beyond #1"</span><span class="token punctuation">,</span>
        <span class="token property">"publisher"</span><span class="token operator">:</span> <span class="token string">"DC Comics"</span><span class="token punctuation">,</span>
        <span class="token property">"alignment"</span><span class="token operator">:</span> <span class="token string">"good"</span>
      <span class="token punctuation">}</span><span class="token punctuation">,</span>
      <span class="token property">"appearance"</span><span class="token operator">:</span> <span class="token punctuation">{</span>
        <span class="token property">"gender"</span><span class="token operator">:</span> <span class="token string">"Male"</span><span class="token punctuation">,</span>
        <span class="token property">"race"</span><span class="token operator">:</span> <span class="token string">"Human"</span><span class="token punctuation">,</span>
        <span class="token property">"height"</span><span class="token operator">:</span> <span class="token punctuation">[</span>
          <span class="token string">"5'10"</span><span class="token punctuation">,</span>
          <span class="token string">"178 cm"</span>
        <span class="token punctuation">]</span><span class="token punctuation">,</span>
        <span class="token property">"weight"</span><span class="token operator">:</span> <span class="token punctuation">[</span>
          <span class="token string">"170 lb"</span><span class="token punctuation">,</span>
          <span class="token string">"77 kg"</span>
        <span class="token punctuation">]</span><span class="token punctuation">,</span>
        <span class="token property">"eye-color"</span><span class="token operator">:</span> <span class="token string">"Blue"</span><span class="token punctuation">,</span>
        <span class="token property">"hair-color"</span><span class="token operator">:</span> <span class="token string">"Black"</span>
      <span class="token punctuation">}</span><span class="token punctuation">,</span>
      <span class="token property">"work"</span><span class="token operator">:</span> <span class="token punctuation">{</span>
        <span class="token property">"occupation"</span><span class="token operator">:</span> <span class="token string">"-"</span><span class="token punctuation">,</span>
        <span class="token property">"base"</span><span class="token operator">:</span> <span class="token string">"21st Century Gotham City"</span>
      <span class="token punctuation">}</span><span class="token punctuation">,</span>
      <span class="token property">"connections"</span><span class="token operator">:</span> <span class="token punctuation">{</span>
        <span class="token property">"group-affiliation"</span><span class="token operator">:</span> <span class="token string">"Batman Family, Justice League Unlimited"</span><span class="token punctuation">,</span>
        <span class="token property">"relatives"</span><span class="token operator">:</span> <span class="token string">"Bruce Wayne (biological father), Warren McGinnis (father, deceased), Mary McGinnis (mother), Matt McGinnis (brother)"</span>
      <span class="token punctuation">}</span><span class="token punctuation">,</span>
      <span class="token property">"image"</span><span class="token operator">:</span> <span class="token punctuation">{</span>
        <span class="token property">"url"</span><span class="token operator">:</span> <span class="token string">"https://www.superherodb.com/pictures2/portraits/10/100/10441.jpg"</span>
      <span class="token punctuation">}</span>
    <span class="token punctuation">}</span><span class="token punctuation">,</span>
    <span class="token punctuation">{</span>
      <span class="token property">"id"</span><span class="token operator">:</span> <span class="token string">"70"</span><span class="token punctuation">,</span>
      <span class="token property">"name"</span><span class="token operator">:</span> <span class="token string">"Batman"</span><span class="token punctuation">,</span>
      <span class="token property">"powerstats"</span><span class="token operator">:</span> <span class="token punctuation">{</span>
        <span class="token property">"intelligence"</span><span class="token operator">:</span> <span class="token string">"100"</span><span class="token punctuation">,</span>
        <span class="token property">"strength"</span><span class="token operator">:</span> <span class="token string">"26"</span><span class="token punctuation">,</span>
        <span class="token property">"speed"</span><span class="token operator">:</span> <span class="token string">"27"</span><span class="token punctuation">,</span>
        <span class="token property">"durability"</span><span class="token operator">:</span> <span class="token string">"50"</span><span class="token punctuation">,</span>
        <span class="token property">"power"</span><span class="token operator">:</span> <span class="token string">"47"</span><span class="token punctuation">,</span>
        <span class="token property">"combat"</span><span class="token operator">:</span> <span class="token string">"100"</span>
      <span class="token punctuation">}</span><span class="token punctuation">,</span>
      <span class="token property">"biography"</span><span class="token operator">:</span> <span class="token punctuation">{</span>
        <span class="token property">"full-name"</span><span class="token operator">:</span> <span class="token string">"Bruce Wayne"</span><span class="token punctuation">,</span>
        <span class="token property">"alter-egos"</span><span class="token operator">:</span> <span class="token string">"No alter egos found."</span><span class="token punctuation">,</span>
        <span class="token property">"aliases"</span><span class="token operator">:</span> <span class="token punctuation">[</span>
          <span class="token string">"Insider"</span><span class="token punctuation">,</span>
          <span class="token string">"Matches Malone"</span>
        <span class="token punctuation">]</span><span class="token punctuation">,</span>
        <span class="token property">"place-of-birth"</span><span class="token operator">:</span> <span class="token string">"Crest Hill, Bristol Township; Gotham County"</span><span class="token punctuation">,</span>
        <span class="token property">"first-appearance"</span><span class="token operator">:</span> <span class="token string">"Detective Comics #27"</span><span class="token punctuation">,</span>
        <span class="token property">"publisher"</span><span class="token operator">:</span> <span class="token string">"DC Comics"</span><span class="token punctuation">,</span>
        <span class="token property">"alignment"</span><span class="token operator">:</span> <span class="token string">"good"</span>
      <span class="token punctuation">}</span><span class="token punctuation">,</span>
      <span class="token property">"appearance"</span><span class="token operator">:</span> <span class="token punctuation">{</span>
        <span class="token property">"gender"</span><span class="token operator">:</span> <span class="token string">"Male"</span><span class="token punctuation">,</span>
        <span class="token property">"race"</span><span class="token operator">:</span> <span class="token string">"Human"</span><span class="token punctuation">,</span>
        <span class="token property">"height"</span><span class="token operator">:</span> <span class="token punctuation">[</span>
          <span class="token string">"6'2"</span><span class="token punctuation">,</span>
          <span class="token string">"188 cm"</span>
        <span class="token punctuation">]</span><span class="token punctuation">,</span>
        <span class="token property">"weight"</span><span class="token operator">:</span> <span class="token punctuation">[</span>
          <span class="token string">"210 lb"</span><span class="token punctuation">,</span>
          <span class="token string">"95 kg"</span>
        <span class="token punctuation">]</span><span class="token punctuation">,</span>
        <span class="token property">"eye-color"</span><span class="token operator">:</span> <span class="token string">"blue"</span><span class="token punctuation">,</span>
        <span class="token property">"hair-color"</span><span class="token operator">:</span> <span class="token string">"black"</span>
      <span class="token punctuation">}</span><span class="token punctuation">,</span>
      <span class="token property">"work"</span><span class="token operator">:</span> <span class="token punctuation">{</span>
        <span class="token property">"occupation"</span><span class="token operator">:</span> <span class="token string">"Businessman"</span><span class="token punctuation">,</span>
        <span class="token property">"base"</span><span class="token operator">:</span> <span class="token string">"Batcave, Stately Wayne Manor, Gotham City; Hall of Justice, Justice League Watchtower"</span>
      <span class="token punctuation">}</span><span class="token punctuation">,</span>
      <span class="token property">"connections"</span><span class="token operator">:</span> <span class="token punctuation">{</span>
        <span class="token property">"group-affiliation"</span><span class="token operator">:</span> <span class="token string">"Batman Family, Batman Incorporated, Justice League, Outsiders, Wayne Enterprises, Club of Heroes, formerly White Lantern Corps, Sinestro Corps"</span><span class="token punctuation">,</span>
        <span class="token property">"relatives"</span><span class="token operator">:</span> <span class="token string">"Damian Wayne (son), Dick Grayson (adopted son), Tim Drake (adopted son), Jason Todd (adopted son), Cassandra Cain (adopted ward)\nMartha Wayne (mother, deceased), Thomas Wayne (father, deceased), Alfred Pennyworth (former guardian), Roderick Kane (grandfather, deceased), Elizabeth Kane (grandmother, deceased), Nathan Kane (uncle, deceased), Simon Hurt (ancestor), Wayne Family"</span>
      <span class="token punctuation">}</span><span class="token punctuation">,</span>
      <span class="token property">"image"</span><span class="token operator">:</span> <span class="token punctuation">{</span>
        <span class="token property">"url"</span><span class="token operator">:</span> <span class="token string">"https://www.superherodb.com/pictures2/portraits/10/100/639.jpg"</span>
      <span class="token punctuation">}</span>
    <span class="token punctuation">}</span><span class="token punctuation">,</span>
    <span class="token punctuation">{</span>
      <span class="token property">"id"</span><span class="token operator">:</span> <span class="token string">"71"</span><span class="token punctuation">,</span>
      <span class="token property">"name"</span><span class="token operator">:</span> <span class="token string">"Batman II"</span><span class="token punctuation">,</span>
      <span class="token property">"powerstats"</span><span class="token operator">:</span> <span class="token punctuation">{</span>
        <span class="token property">"intelligence"</span><span class="token operator">:</span> <span class="token string">"88"</span><span class="token punctuation">,</span>
        <span class="token property">"strength"</span><span class="token operator">:</span> <span class="token string">"11"</span><span class="token punctuation">,</span>
        <span class="token property">"speed"</span><span class="token operator">:</span> <span class="token string">"33"</span><span class="token punctuation">,</span>
        <span class="token property">"durability"</span><span class="token operator">:</span> <span class="token string">"28"</span><span class="token punctuation">,</span>
        <span class="token property">"power"</span><span class="token operator">:</span> <span class="token string">"36"</span><span class="token punctuation">,</span>
        <span class="token property">"combat"</span><span class="token operator">:</span> <span class="token string">"100"</span>
      <span class="token punctuation">}</span><span class="token punctuation">,</span>
      <span class="token property">"biography"</span><span class="token operator">:</span> <span class="token punctuation">{</span>
        <span class="token property">"full-name"</span><span class="token operator">:</span> <span class="token string">"Dick Grayson"</span><span class="token punctuation">,</span>
        <span class="token property">"alter-egos"</span><span class="token operator">:</span> <span class="token string">"Nightwing, Robin"</span><span class="token punctuation">,</span>
        <span class="token property">"aliases"</span><span class="token operator">:</span> <span class="token punctuation">[</span>
          <span class="token string">"Dick Grayson"</span>
        <span class="token punctuation">]</span><span class="token punctuation">,</span>
        <span class="token property">"place-of-birth"</span><span class="token operator">:</span> <span class="token string">"-"</span><span class="token punctuation">,</span>
        <span class="token property">"first-appearance"</span><span class="token operator">:</span> <span class="token string">"-"</span><span class="token punctuation">,</span>
        <span class="token property">"publisher"</span><span class="token operator">:</span> <span class="token string">"Nightwing"</span><span class="token punctuation">,</span>
        <span class="token property">"alignment"</span><span class="token operator">:</span> <span class="token string">"good"</span>
      <span class="token punctuation">}</span><span class="token punctuation">,</span>
      <span class="token property">"appearance"</span><span class="token operator">:</span> <span class="token punctuation">{</span>
        <span class="token property">"gender"</span><span class="token operator">:</span> <span class="token string">"Male"</span><span class="token punctuation">,</span>
        <span class="token property">"race"</span><span class="token operator">:</span> <span class="token string">"Human"</span><span class="token punctuation">,</span>
        <span class="token property">"height"</span><span class="token operator">:</span> <span class="token punctuation">[</span>
          <span class="token string">"5'10"</span><span class="token punctuation">,</span>
          <span class="token string">"178 cm"</span>
        <span class="token punctuation">]</span><span class="token punctuation">,</span>
        <span class="token property">"weight"</span><span class="token operator">:</span> <span class="token punctuation">[</span>
          <span class="token string">"175 lb"</span><span class="token punctuation">,</span>
          <span class="token string">"79 kg"</span>
        <span class="token punctuation">]</span><span class="token punctuation">,</span>
        <span class="token property">"eye-color"</span><span class="token operator">:</span> <span class="token string">"Blue"</span><span class="token punctuation">,</span>
        <span class="token property">"hair-color"</span><span class="token operator">:</span> <span class="token string">"Black"</span>
      <span class="token punctuation">}</span><span class="token punctuation">,</span>
      <span class="token property">"work"</span><span class="token operator">:</span> <span class="token punctuation">{</span>
        <span class="token property">"occupation"</span><span class="token operator">:</span> <span class="token string">"-"</span><span class="token punctuation">,</span>
        <span class="token property">"base"</span><span class="token operator">:</span> <span class="token string">"Gotham City; formerly Bludhaven, New York City"</span>
      <span class="token punctuation">}</span><span class="token punctuation">,</span>
      <span class="token property">"connections"</span><span class="token operator">:</span> <span class="token punctuation">{</span>
        <span class="token property">"group-affiliation"</span><span class="token operator">:</span> <span class="token string">"Justice League Of America, Batman Family"</span><span class="token punctuation">,</span>
        <span class="token property">"relatives"</span><span class="token operator">:</span> <span class="token string">"John Grayson (father, deceased), Mary Grayson (mother, deceased), Bruce Wayne / Batman (adoptive father), Damian Wayne / Robin (foster brother), Jason Todd / Red Hood (adoptive brother), Tim Drake / Red Robin (adoptive brother), Cassandra Cain / Batgirl IV (adoptive sister)"</span>
      <span class="token punctuation">}</span><span class="token punctuation">,</span>
      <span class="token property">"image"</span><span class="token operator">:</span> <span class="token punctuation">{</span>
        <span class="token property">"url"</span><span class="token operator">:</span> <span class="token string">"https://www.superherodb.com/pictures2/portraits/10/100/1496.jpg"</span>
      <span class="token punctuation">}</span>
    <span class="token punctuation">}</span>
  <span class="token punctuation">]</span>
<span class="token punctuation">}</span><span aria-hidden="true" class="line-numbers-rows"><span></span><span></span><span></span><span></span><span></span><span></span><span></span><span></span><span></span><span></span><span></span><span></span><span></span><span></span><span></span><span></span><span></span><span></span><span></span><span></span><span></span><span></span><span></span><span></span><span></span><span></span><span></span><span></span><span></span><span></span><span></span><span></span><span></span><span></span><span></span><span></span><span></span><span></span><span></span><span></span><span></span><span></span><span></span><span></span><span></span><span></span><span></span><span></span><span></span><span></span><span></span><span></span><span></span><span></span><span></span><span></span><span></span><span></span><span></span><span></span><span></span><span></span><span></span><span></span><span></span><span></span><span></span><span></span><span></span><span></span><span></span><span></span><span></span><span></span><span></span><span></span><span></span><span></span><span></span><span></span><span></span><span></span><span></span><span></span><span></span><span></span><span></span><span></span><span></span><span></span><span></span><span></span><span></span><span></span><span></span><span></span><span></span><span></span><span></span><span></span><span></span><span></span><span></span><span></span><span></span><span></span><span></span><span></span><span></span><span></span><span></span><span></span><span></span><span></span><span></span><span></span><span></span><span></span><span></span><span></span><span></span><span></span><span></span><span></span><span></span><span></span><span></span><span></span><span></span><span></span><span></span><span></span><span></span><span></span><span></span><span></span><span></span><span></span><span></span><span></span><span></span><span></span><span></span><span></span><span></span><span></span><span></span><span></span><span></span><span></span><span></span><span></span><span></span><span></span><span></span></span></code></pre></div>
							
						</div>


				</section>

## What Will I Learn?
Through this project, you will:
- Learn how to submit projects for review
- Practice JSON parsing to a model object
- Design an activity layout
- Populate all fields in the layout accordingly

## How Do I Complete this Project?
Download the [Sandwich Club app starter code.](https://github.com/udacity/sandwich-club-starter-code)

Design the layout for the detail activity so the different elements
display in a sensible way. Implement the JSON parsing in JsonUtils so it
produces a Sandwich Object that can be used to populate the UI that you designed.
