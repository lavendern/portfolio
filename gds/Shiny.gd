extends Item
class_name Shiny

export var rarity:int # 1, 2, 4, 8
export var size:int # S M L XL 1, 2, 4, 6


func _ready()->void:
	id = 0
	if rarity==0:
		var rand = rand_range(0.0,100.0)
		if rand > 98.0:
			rarity = 8
		elif rand > 85.0:
			rarity = 4
		elif rand > 50:
			rarity = 2
		else: rarity=1
	if size==0:
		var rand = rand_range(0.0,100.0)
		if rand > 95.0:
			size = 6
		elif rand > 80.0:
			size = 4
		elif rand > 50:
			size = 2
		else: size=1
	itemCount=1*size*rarity
	$RigidBody/MeshInstance.mesh = _chooseModel()
	$RigidBody/CollisionShape.make_convex_from_brothers();
	# TODO: change shader based on luster and rarity

func _chooseModel()->Resource:
	if size<4:
		if rarity<4:
			var rand = rand_range(0.0,10.0)
			if rand > 7.5: return load("res://models/Jewel.mesh")
			elif rand > 5: return load("res://models/Gem.mesh")
			else: return load("res://models/Ore.mesh")
		elif rarity==8:
			return load("res://models/Diamond.mesh")
	elif size==4:
		var rand = rand_range(0.0,1.0)
		if rand > .5: return load("res://models/CrystalL.mesh")
		else: return load("res://models/CrystalL2.mesh")
	elif size==6:
		return load("res://models/CrystalXL.mesh")
	return load("res://models/Gem.mesh")
